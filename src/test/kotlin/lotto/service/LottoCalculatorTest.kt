package lotto.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto

class LottoCalculatorTest : FunSpec({
    context("로또의 일치 개수를 확인한다.") {
        withData(
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 6))) to 6,
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 7))) to 5,
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 7, 8))) to 4,
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(7, 8, 9, 10, 11, 12))) to 0,
        ) { (lottoAndWinningLotto, expectedCount) ->
            val (lotto, winningLotto) = lottoAndWinningLotto
            val matchCount = lotto.countMatch(winningLotto)
            matchCount shouldBe expectedCount
        }
    }

    context("로또 일치 개수별 당첨금을 확인한다.") {
        withData(
            0 to 0,
            1 to 0,
            2 to 0,
            3 to 5_000,
            4 to 50_000,
            5 to 1_500_000,
            6 to 2_000_000_000,
        ) { (matchCount, expectedMoney) ->
            val money = LottoCalculator.calculatePrizeMoney(matchCount)
            money shouldBe expectedMoney
        }
    }
})
