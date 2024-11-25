package lotto.view

import lotto.domain.PurchasedLottos
import lotto.domain.Rank
import lotto.domain.WinningStatistics
import java.math.BigDecimal

class OutPutView {
    fun printLottoCount(
        count: Int,
        manualCount: Int,
    ) {
        val autoCount = count - manualCount
        println("수동으로 ${manualCount}장, 자동으로 ${autoCount}개를 구매했습니다.")
    }

    fun printPurchasedLottos(purchasedLottos: PurchasedLottos) {
        purchasedLottos
            .lottos
            .forEach {
                println(it.numbers.map { it.value })
            }
        println()
    }

    fun printStatistics(statistics: WinningStatistics) {
        println(formatStatistics(statistics))
    }

    private fun formatStatistics(statistics: WinningStatistics): String {
        val builder = StringBuilder()
        builder.append("당첨 통계\n---------\n")
        Rank.entries
            .filter { it != Rank.MISS }
            .forEach { rank -> builder.append(formatRankOutput(rank, statistics)) }

        return builder.toString()
    }

    fun printProfitRate(profitRate: BigDecimal) {
        println(
            "총 수익률은 %.2f입니다.${if (profitRate < BigDecimal.ONE) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else ""}".format(
                profitRate,
            ),
        )
    }

    private fun formatRankOutput(
        rank: Rank,
        statistics: WinningStatistics,
    ): String {
        return if (rank == Rank.SECOND) {
            "5개 일치, 보너스 볼 일치 (${rank.prize}원) - ${statistics.count(rank).value}개\n"
        } else {
            "${rank.matchCount}개 일치 (${rank.prize}원) - ${statistics.count(rank).value}개\n"
        }
    }
}
