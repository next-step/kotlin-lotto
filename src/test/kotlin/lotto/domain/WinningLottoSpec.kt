package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class WinningLottoSpec : FunSpec({

    context("당첨 로또 생성") {
        test("당첨 티켓과 보너스 볼로 당첨 로또가 생성된다") {
            WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), 45)
        }
        test("당첨 번호에 보너스 볼이 포함되어 있으면 에러가 발생한다") {
            shouldThrow<IllegalArgumentException> {
                WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), 6)
            }
        }
        test("보너스볼이 1부터 45사이의 숫자가 아니라면 에러가 발생한다") {
            forAll(
                row(0),
                row(46),
            ) { bonusNumber ->
                shouldThrow<IllegalArgumentException> {
                    WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), bonusNumber)
                }
            }
        }
    }

    context("일치하는 개수에 따른 Rank 계산") {
        val bonusNumber = 7
        val winningLotto = WinningLotto(
            winningNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 6)),
            bonusNumber = bonusNumber,
        )
        context("숫자가 하나도 일치하지 않았다면 Rank MISS 반환") {

            val noneMatchedNumber = LottoNumber(listOf(100, 101, 102, 103, 104, 105))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.MISS
        }

        test("숫자가 하나도 일치하지 않았다면 보너스 볼이 일치했더라도 Rank MISS 반환") {
            val noneMatchedNumber = LottoNumber(listOf(100, 101, 102, 103, 104, bonusNumber))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.MISS
        }

        test("숫자가 1개 일치했다면 Rank MISS 반환") {
            val noneMatchedNumber = LottoNumber(listOf(1, 101, 102, 103, 104, 105))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.MISS
        }

        test("숫자가 1개 일치했다면 보너스 볼이 일치했더라도 Rank MISS 반환") {
            val noneMatchedNumber = LottoNumber(listOf(1, 101, 102, 103, 104, bonusNumber))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.MISS
        }

        test("숫자가 2개 일치했다면 Rank MISS 반환") {
            val noneMatchedNumber = LottoNumber(listOf(1, 2, 102, 103, 104, 105))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.MISS
        }

        test("숫자가 2개 일치했다면 보너스 볼이 일치했더라도 Rank MISS 반환") {
            val noneMatchedNumber = LottoNumber(listOf(1, 2, 102, 103, 104, bonusNumber))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.MISS
        }

        test("숫자가 3개 일치했다면 Rank FIFTH 반환") {
            val noneMatchedNumber = LottoNumber(listOf(1, 2, 3, 103, 104, 105))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.FIFTH
        }

        test("숫자가 3개 일치했다면 보너스 볼이 일치했더라도 Rank FIFTH 반환") {
            val noneMatchedNumber = LottoNumber(listOf(1, 2, 3, 103, 104, bonusNumber))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.FIFTH
        }

        test("숫자가 4개 일치했다면 Rank FOURTH 반환") {
            val noneMatchedNumber = LottoNumber(listOf(1, 2, 3, 4, 104, 105))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.FOURTH
        }

        test("숫자가 4개 일치했다면 보너스 볼이 일치했더라도 Rank FOURTH 반환") {
            val noneMatchedNumber = LottoNumber(listOf(1, 2, 3, 4, 104, bonusNumber))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.FOURTH
        }

        test("숫자가 5개 일치하고 보너스 볼이 일치하지 않았다면 Rank THIRD 반환") {
            val noneMatchedNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 105))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.THIRD
        }

        test("숫자가 5개 일치했다면 보너스 볼이 일치했더라도 Rank SECOND 반환") {
            val noneMatchedNumber = LottoNumber(listOf(1, 2, 3, 4, 5, bonusNumber))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.SECOND
        }

        test("숫자가 6개 일치했다면 Rank FIRST 반환") {
            val noneMatchedNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 6))

            val result = winningLotto.rank(noneMatchedNumber)

            result shouldBe LottoRank.FIRST
        }
    }
})
