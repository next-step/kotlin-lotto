package lotto.view

object Screen {
    private val MATCH_PRICE_MAP = mapOf(
        3 to 5_000,
        4 to 50_000,
        5 to 1_500_000,
        6 to 2_000_000_000
    )

    fun display(price: Int, statistics: Map<Int, Int>) {
        displayStatistics(statistics)
        displayReturnRate(price, statistics)
    }

    private fun displayStatistics(statistics: Map<Int, Int>) {
        println("당첨 통계")
        println("---------")

        for ((matchNumber, matchCount) in statistics) {
            displayStatistic(matchNumber, matchCount)
        }
    }

    private fun displayStatistic(matchNumber: Int, matchCount: Int) {
        println("${matchNumber}개 일치 (${getPrice(matchNumber)}원)- ${matchCount}개", )
    }

    private fun displayReturnRate(price: Int, statistics: Map<Int, Int>) {
        val returnRate = calculateReturnRate(price, statistics)
        println("총 수익률은 ${String.format("%.2f", returnRate)}입니다.")
    }

    private fun calculateReturnRate(price: Int, statistics: Map<Int, Int>): Double {
        return (calculateReturnPrice(statistics) / price.toDouble())
    }

    private fun calculateReturnPrice(statistics: Map<Int, Int>): Int {
        var returnPrice = 0

        for ((matchNumber, matchCount) in statistics) {
            returnPrice += matchCount * getPrice(matchNumber)
        }

        return returnPrice
    }

    private fun getPrice(matchNumber: Int): Int {
        return MATCH_PRICE_MAP[matchNumber] ?: 0
    }
}
