package lotto.view

object Screen {
    private val MATCH_PRICE_MAP = mapOf(
        3 to 5_000,
        4 to 50_000,
        5 to 1_500_000,
        6 to 2_000_000_000
    )

    fun display(statistics: Map<Int, Int>) {
        displayStatistics(statistics)
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

    private fun getPrice(matchNumber: Int): Int {
        return MATCH_PRICE_MAP[matchNumber] ?: 0
    }
}
