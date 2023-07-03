package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class WinningStatisticsTest : FunSpec({
    context("로또번호 일치 개수별 당첨된 로또 개수를 확인한다.") {
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 10, 11, 12, 13, 14)), // 1개
                Lotto(listOf(1, 10, 11, 12, 13, 14)), // 1개

                Lotto(listOf(1, 2, 10, 11, 12, 13)), // 2개

                Lotto(listOf(1, 2, 3, 10, 11, 12)), // 3개

                Lotto(listOf(1, 2, 3, 4, 10, 11)), // 4개

                Lotto(listOf(1, 2, 3, 4, 5, 10)), // 5개

                Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6개
                Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6개
            ),
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val winningStatistics = WinningStatistics.of(lottos, winningLotto)

        winningStatistics.winningStatistics[1] shouldBe 2
        winningStatistics.winningStatistics[2] shouldBe 1
        winningStatistics.winningStatistics[3] shouldBe 1
        winningStatistics.winningStatistics[4] shouldBe 1
        winningStatistics.winningStatistics[5] shouldBe 1
        winningStatistics.winningStatistics[6] shouldBe 2
    }

    context("총 수익금을 계산한다.") {
        withData(
            (WinningStatistics(mapOf(1 to 2, 2 to 1, 3 to 1, 4 to 1, 5 to 1, 6 to 2)) to 4_001_555_000L),
            (WinningStatistics(mapOf(1 to 2, 2 to 1, 3 to 1, 4 to 0, 5 to 0, 6 to 0)) to 5000L),
        ) { (winningStatistics, expectedTotalPrizeMoney) ->
            winningStatistics.calculateTotalPrizeMoney() shouldBe expectedTotalPrizeMoney
        }
    }

    context("총 수익률을 계산한다.") {
        withData(
            (WinningStatistics(mapOf(1 to 2, 2 to 1, 3 to 1, 4 to 1, 5 to 1, 6 to 2)) to 1000L) to 4_001_555.0,
            (WinningStatistics(mapOf(1 to 2, 2 to 1, 3 to 1, 4 to 0, 5 to 0, 6 to 0)) to 1000L) to 5.0,
        ) { (winningStatisticsAndPurchaseMoney, expectedProfitRate) ->
            val (winningStatistics, purchaseMoney) = winningStatisticsAndPurchaseMoney
            val profitRate = winningStatistics.calculateProfitRate(purchaseMoney)
            profitRate shouldBe expectedProfitRate
        }
    }
})
