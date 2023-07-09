package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class WinningStatisticsTest : FunSpec({
    context("총 수익률을 계산한다.") {
        withData(
            (
                WinningStatistics(
                    mapOf(
                        Rank.MISS to 3,
                        Rank.FIFTH to 1,
                        Rank.FOURTH to 1,
                        Rank.THIRD to 1,
                        Rank.FIRST to 2,
                    ),
                ) to 1000L
                ) to 4_001_555.0,
            (
                WinningStatistics(
                    mapOf(
                        Rank.MISS to 3,
                        Rank.FIFTH to 1,
                        Rank.FOURTH to 0,
                        Rank.THIRD to 0,
                        Rank.FIRST to 0,
                    ),
                ) to 1000L
                ) to 5.0,
        ) { (winningStatisticsAndPurchaseMoney, expectedProfitRate) ->
            val (winningStatistics, purchaseMoney) = winningStatisticsAndPurchaseMoney
            val profitRate = winningStatistics.calculateProfitRate(PurchaseMoney(purchaseMoney))
            profitRate shouldBe expectedProfitRate
        }
    }
})
