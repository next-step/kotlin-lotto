package lotto.ui

object StatisticsView {
    fun printResult(money: Long, matchingMap: Map<Int, Int>) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${matchingMap.getOrDefault(3, 0)}개")
        println("4개 일치 (50000원)- ${matchingMap.getOrDefault(4, 0)}개")
        println("5개 일치 (1500000원)- ${matchingMap.getOrDefault(5, 0)}개")
        println("6개 일치 (2000000000원)- ${matchingMap.getOrDefault(6, 0)}개")

        val revenue = calculateRevenue(matchingMap)
        println("총 수익률은 ${rateOfReturn(money, revenue)}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    private fun calculateRevenue(matchingMap: Map<Int, Int>): Long {
        return matchingMap.entries
            .sumOf { (matchCount, count) ->
                when (matchCount) {
                    3 -> 5_000 * count
                    4 -> 50_000 * count
                    5 -> 1_500_000 * count
                    6 -> 2_000_000_000 * count
                    else -> 0
                }.toLong()
            }
    }

    private fun rateOfReturn(money: Long, revenue: Long): String {
        return String.format("%.2f", revenue.toDouble() / money.toDouble())
    }
}
