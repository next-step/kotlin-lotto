package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.constants.WinningRank
import lotto.domain.LottoStore.takeShuffleNumber

class LottoTest : FunSpec({

    test("로또 1장은 6개의 숫자를 가진다.") {
        val numbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val lotto = Lotto(numbers)
        lotto.lottoNumbers shouldBe numbers
    }

    test("숫자5개가 주어졌을때, 로또를 생성하면, 에러가 발생한다") {
        val numbers = LottoNumbers(listOf(1, 2, 3, 4, 5).map { LottoNumber(it) })
        val exception = shouldThrow<IllegalArgumentException> {
            Lotto(numbers)
        }
        exception.message shouldBe "로또는 6개의 숫자만 가질 수 있습니다."
    }

    test("로또 1장의 숫자는 오름차순으로 정렬되어 있다.") {
        val lotto = Lotto(takeShuffleNumber(6))
        lotto.lottoNumbers.numbers shouldBe lotto.lottoNumbers.numbers.sortedBy { it.number }
    }

    test("당첨번호와 로또번호를 비교하여 3개 이상 일치하면 5등이다.") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 7, 8, 9).map { LottoNumber(it) })
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningLotto = WinningLotto(winningNumbers, LottoNumber(7))
        val lottoRank = lotto.winningRank(winningLotto)

        lottoRank shouldBe WinningRank.FIFTH
        lottoRank.count shouldBe 3
    }

    test("당첨번호와 로또번호를 비교하여 4개 이상 일치하면 4등이다.") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 8, 9).map { LottoNumber(it) })
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningLotto = WinningLotto(winningNumbers, LottoNumber(7))
        val lottoRank = lotto.winningRank(winningLotto)

        lottoRank shouldBe WinningRank.FOURTH
        lottoRank.count shouldBe 4
    }

    test("당첨번호와 로또번호를 비교하여 5개 이상 일치하면 3등이다.") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 9).map { LottoNumber(it) })
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningLotto = WinningLotto(winningNumbers, LottoNumber(7))
        val lottoRank = lotto.winningRank(winningLotto)

        lottoRank shouldBe WinningRank.THIRD
        lottoRank.count shouldBe 5
    }

    test("당첨번호와 로또번호를 비교하여 5개 일치하고, 보너스 번호와 일치하면 2등이다.") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 9).map { LottoNumber(it) })
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningLotto = WinningLotto(winningNumbers, LottoNumber(9))
        val lottoRank = lotto.winningRank(winningLotto)

        lottoRank shouldBe WinningRank.SECOND
        lottoRank.count shouldBe 5
    }

    test("당첨번호와 로또번호를 비교하여 6개 일치하면 1등이다.") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningLotto = WinningLotto(winningNumbers, LottoNumber(7))
        val lottoRank = lotto.winningRank(winningLotto)

        lottoRank shouldBe WinningRank.FIRST
        lottoRank.count shouldBe 6
    }
})
