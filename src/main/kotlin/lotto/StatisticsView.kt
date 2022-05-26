package lotto

object StatisticsView {
    fun getReport(statistics: Statistics) {
        println("당첨 통계")
        println("---------")
        printResult(MatchEnum.THREE, statistics.three)
        printResult(MatchEnum.FOUR, statistics.four)
        printResult(MatchEnum.FIVE, statistics.five)
        printResult(MatchEnum.SIX, statistics.six)
    }

    fun getResult(statistics: Statistics, insertAmount: Int) {
        println("총 수익률은 ${getResultRate(statistics, insertAmount)} 입니다. ")
    }

    private fun printResult(matchEnum: MatchEnum, matchCount: Int) {
        println("${matchEnum.count}개 일치 (${matchEnum.amount}원) - ${matchCount}개")
    }

    private fun getResultRate(statistics: Statistics, insertAmount: Int): String {
        val result = statistics.result.toDouble() / insertAmount.toDouble()
        return String.format("%.2f", result)
    }
}
