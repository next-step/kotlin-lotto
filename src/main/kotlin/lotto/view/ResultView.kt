package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinningStatistics

object ResultView {
    fun printPurchaseInfo(tickets: LottoTickets, manualCount: Int, autoCount: Int) {
        println("수동으로 ${manualCount}장, 자동으로 ${autoCount}개를 구매했습니다.")
        tickets.getTickets().forEach { println(it.getNumbers()) }
    }

    fun printStatistics(
        statistics: WinningStatistics,
        profitRate: Double,
    ) {
        println("당첨 통계")
        println("---------")
        StatisticsFormatter.formatDescriptions(statistics).forEach { println(it) }
        println("총 수익률: ${"%.2f".format(profitRate)}")
    }
}
