package lotto.view

import lotto.domain.Lotto

object ResultView {
    fun printPurchaseInfo(tickets: List<Lotto>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printStatistics(
        statistics: Map<Int, Int>,
        profitRate: Double,
    ) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${statistics[3] ?: 0}개")
        println("4개 일치 (50000원)- ${statistics[4] ?: 0}개")
        println("5개 일치 (1500000원)- ${statistics[5] ?: 0}개")
        println("6개 일치 (2000000000원)- ${statistics[6] ?: 0}개")
        println("총 수익률은 ${profitRate}입니다.")
    }
}
