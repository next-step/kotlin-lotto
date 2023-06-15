package view

import domain.Lottery

class OutputView(private val winningNums: List<Int>) {
    private val prizeMap = mapOf(
        3 to 5_000,
        4 to 50_000,
        5 to 1_500_000,
        6 to 2_000_000_000
    )

    fun calculateProfit(lotteries: List<Lottery>): Int {
        val prizeCountMap = HashMap<Int, Int>()
        for (lottery in lotteries) {
            val matchedCount = lottery.countMatchingLottery(winningNums)
            if (matchedCount > 2) prizeCountMap[matchedCount] = (prizeCountMap[matchedCount] ?: 0) + 1
        }

        return getTotalProfit(prizeCountMap)
    }

    private fun getTotalProfit(prizeCountMap: HashMap<Int, Int>): Int {
        var totalPrize = 0

        for (idx in 3..6) {
            val count = prizeCountMap[idx] ?: 0
            val prize = prizeMap[idx] ?: 0
            println("${idx}개 일치 (${prize}원) - $count")
            totalPrize += count * prize
        }

        return totalPrize
    }

    fun reportProfit(returnOnInvestment: Double) {
        val formattedROI = "%.2f".format(returnOnInvestment)
        val message = if (returnOnInvestment > 1) {
            "이익을 얻었습니다."
        } else {
            "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        }
        println("총 수익률은 ${formattedROI}입니다.$message")
    }
}
