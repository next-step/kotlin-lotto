package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinningStatistics

object ResultView {
    fun printPurchaseInfo(tickets: List<Lotto>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printStatistics(
        statistics: WinningStatistics,
        profitRate: Double,
    ) {
        println("당첨 통계")
        println("---------")
        statistics.getDescriptions().forEach { println(it) }
        println("총 수익률: ${"%.2f".format(profitRate)}")
    }
}
