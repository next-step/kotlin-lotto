package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinningCategory

object ResultView {
    fun printPurchaseInfo(tickets: List<Lotto>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printStatistics(
        statistics: Map<WinningCategory, Int>,
        profitRate: Double,
    ) {
        println("당첨 통계")
        println("---------")
        WinningCategory.entries.forEach { category ->
            val count = statistics[category] ?: 0
            println("${category.matchCount}개 일치 (${category.prize}원)- ${count}개")
        }
        println("총 수익률은 ${"%.2f".format(profitRate)}입니다.")
    }
}
