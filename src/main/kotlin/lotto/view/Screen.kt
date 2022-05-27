package lotto.view

import lotto.domain.enum.Priority

object Screen {
    fun display(
        statistics: Map<Int, Int>,
        returnRate: Double
    ) {
        displayStatistics(statistics)
        displayReturnRate(returnRate)
    }

    private fun displayStatistics(statistics: Map<Int, Int>) {
        println("당첨 통계")
        println("---------")

        for ((matchNumber, matchCount) in statistics) {
            displayStatistic(matchNumber, matchCount)
        }
    }

    private fun displayStatistic(matchNumber: Int, matchCount: Int) {
        println("${matchNumber}개 일치 (${Priority.getPrice(matchNumber)}원)- ${matchCount}개")
    }

    private fun displayReturnRate(returnRate: Double) {
        println("총 수익률은 ${String.format("%.2f", returnRate)}입니다.")
    }
}
