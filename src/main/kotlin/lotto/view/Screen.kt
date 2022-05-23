package lotto.view

object Screen {
    fun display(
        statistics: Map<Int, Int>,
        priceMap: Map<Int, Int>,
        returnRate: Double
    ) {
        displayStatistics(statistics, priceMap)
        displayReturnRate(returnRate)
    }

    private fun displayStatistics(statistics: Map<Int, Int>, priceMap: Map<Int, Int>) {
        println("당첨 통계")
        println("---------")

        for ((matchNumber, matchCount) in statistics) {
            displayStatistic(matchNumber, matchCount, priceMap)
        }
    }

    private fun displayStatistic(matchNumber: Int, matchCount: Int, priceMap: Map<Int, Int>) {
        println("${matchNumber}개 일치 (${priceMap[matchNumber]}원)- ${matchCount}개")
    }

    private fun displayReturnRate(returnRate: Double) {
        println("총 수익률은 ${String.format("%.2f", returnRate)}입니다.")
    }
}
