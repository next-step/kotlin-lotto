package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class WinningStatisticsTest : FunSpec({
    context("로또번호 일치 개수별 당첨된 로또 개수를 확인한다.") {
        val lottos = Lottos(
            listOf(
                // 꽝
                Lotto(1, 10, 11, 12, 13, 14), // 1개
                Lotto(1, 10, 11, 12, 13, 14), // 1개

                Lotto(1, 2, 10, 11, 12, 13), // 2개

                // 5등
                Lotto(1, 2, 3, 10, 11, 12), // 3개

                // 4등
                Lotto(1, 2, 3, 4, 10, 11), // 4개

                // 3등
                Lotto(1, 2, 3, 4, 5, 10), // 5개

                // 2등
                Lotto(1, 2, 3, 4, 5, 7), // 5개 + 보너스

                // 1등
                Lotto(1, 2, 3, 4, 5, 6), // 6개
                Lotto(1, 2, 3, 4, 5, 6), // 6개
            ),
        )
        val winningLotto = WinningLotto(LottoNumbers(1, 2, 3, 4, 5, 6), 7)

        val winningStatistics = WinningStatistics.of(lottos, winningLotto)

        winningStatistics.winningStatistics[Rank.MISS] shouldBe 3
        winningStatistics.winningStatistics[Rank.FIFTH] shouldBe 1
        winningStatistics.winningStatistics[Rank.FOURTH] shouldBe 1
        winningStatistics.winningStatistics[Rank.THIRD] shouldBe 1
        winningStatistics.winningStatistics[Rank.SECOND] shouldBe 1
        winningStatistics.winningStatistics[Rank.FIRST] shouldBe 2
    }

    context("총 수익금을 계산한다.") {
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
                ) to 4_001_555_000L
                ),
            (
                WinningStatistics(
                    mapOf(
                        Rank.MISS to 3,
                        Rank.FIFTH to 1,
                        Rank.FOURTH to 0,
                        Rank.THIRD to 0,
                        Rank.FIRST to 0,
                    ),
                ) to 5000L
                ),
        ) { (winningStatistics, expectedTotalPrizeMoney) ->
            winningStatistics.calculateTotalPrizeMoney() shouldBe expectedTotalPrizeMoney
        }
    }

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
