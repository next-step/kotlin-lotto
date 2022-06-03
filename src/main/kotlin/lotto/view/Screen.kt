package lotto.view

import lotto.domain.enum.Priority

object Screen {
    fun display(
        statistics: Map<Priority, Int>,
        returnRate: Double
    ) {
        displayStatistics(statistics)
        displayReturnRate(returnRate)
    }

    private fun displayStatistics(statistics: Map<Priority, Int>) {
        println("당첨 통계")
        println("---------")

        for ((priority, count) in statistics) {
            displayStatistic(priority.matchCount, count)
        }
    }

    private fun displayStatistic(matchNumber: Int, count: Int) {
        println("${matchNumber}개 일치 (${Priority.getPrice(matchNumber)}원)- ${count}개")
    }

    private fun displayReturnRate(returnRate: Double) {
        println("총 수익률은 ${String.format("%.2f", returnRate)}입니다.")
    }
}
