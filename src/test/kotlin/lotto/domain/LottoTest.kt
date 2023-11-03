package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import lotto.constants.WinningRank
import lotto.domain.LottoStore.shuffleNumber
import lotto.domain.LottoStore.takeShuffleNumber

class LottoTest : FunSpec({

    test("로또 1장은 6개의 숫자를 가진다.") {
        var numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(takeShuffleNumber(6))
        lotto.numbers.size shouldBe 6

        numbers = listOf(1, 2, 3, 4, 5)
        val exception = shouldThrow<IllegalArgumentException> {
            Lotto(numbers)
        }
        exception.message shouldBe "로또는 6개의 숫자만 가질 수 있습니다."
    }

    test("로또 1장의 숫자는 1부터 45까지의 숫자이다.") {
        var numbers = listOf(1, 2, 3, 4, 5, 45)
        val lotto = Lotto(numbers)
        lotto.numbers.forEach {
            it shouldBeInRange 1..45
        }

        numbers = listOf(1, 2, 3, 4, 5, 46)
        val exception = shouldThrow<IllegalArgumentException> {
            Lotto(numbers)
        }
        exception.message shouldBe "로또는 1~45의 숫자만 가질 수 있습니다."
    }

    test("로또 1장의 숫자는 중복되지 않는다.") {
        var numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        lotto.numbers.toSet().size shouldBe 6

        numbers = listOf(1, 2, 3, 4, 5, 5)
        val exception = shouldThrow<IllegalArgumentException> {
            Lotto(numbers)
        }
        exception.message shouldBe "로또는 중복되지 않는 숫자만 가질 수 있습니다."
    }

    test("로또 1장의 숫자는 오름차순으로 정렬되어 있다.") {
        val lotto = Lotto(takeShuffleNumber(6))
        lotto.numbers shouldBe lotto.numbers.sorted()
    }

    test("당첨번호와 로또번호를 비교한다.") {
        val lotto = Lotto(takeShuffleNumber(6))
        val winningLotto = Lotto(shuffleNumber().take(6))

        val matchCount = lotto.matchCount(winningLotto)
        matchCount shouldBeInRange 0..6
    }

    test("당첨번호와 로또번호를 비교하여 3개 이상 일치하면 4등이다.") {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoRank = lotto.winningRank(winningLotto)

        lottoRank shouldBe WinningRank.FOURTH
        lottoRank.count shouldBe 3
    }

    test("당첨번호와 로또번호를 비교하여 4개 이상 일치하면 3등이다.") {
        val lotto = Lotto(listOf(1, 2, 3, 4, 8, 9))
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoRank = lotto.winningRank(winningLotto)

        lottoRank shouldBe WinningRank.THIRD
        lottoRank.count shouldBe 4
    }

    test("당첨번호와 로또번호를 비교하여 5개 이상 일치하면 2등이다.") {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 9))
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoRank = lotto.winningRank(winningLotto)

        lottoRank shouldBe WinningRank.SECOND
        lottoRank.count shouldBe 5
    }

    test("당첨번호와 로또번호를 비교하여 6개 일치하면 1등이다.") {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoRank = lotto.winningRank(winningLotto)

        lottoRank shouldBe WinningRank.FIRST
        lottoRank.count shouldBe 6
    }
})
