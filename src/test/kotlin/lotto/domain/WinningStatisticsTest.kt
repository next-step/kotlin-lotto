package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class WinningStatisticsTest : FunSpec({
    context("총 수익률을 계산한다.") {
        withData(
            (
                WinningStatistics(
                    Ranks(
                        listOf(
                            Rank.MISS,
                            Rank.MISS,
                            Rank.MISS,
                            Rank.FIFTH,
                            Rank.FOURTH,
                            Rank.THIRD,
                            Rank.FIRST,
                            Rank.FIRST,
                        ),
                    ),
                ) to 1000L
                ) to 4_001_555.0,
            (
                WinningStatistics(
                    Ranks(
                        listOf(
                            Rank.MISS,
                            Rank.MISS,
                            Rank.MISS,
                            Rank.FIFTH,
                        ),
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
