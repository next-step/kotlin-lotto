package domain

import view.OutputView

class Settlement(private val winningNums: Set<Int>) {

    fun getReturnOnInvestment(
        lotteries: List<Lottery>,
        sunkCost: Int
    ): Double {
        val prizeCountMap = mutableMapOf<Int, Int>()

        for (lottery in lotteries) {
            val matchedCount = lottery.countMatchingLottery(winningNums)
            if (matchedCount > 2) prizeCountMap[matchedCount] = (prizeCountMap[matchedCount] ?: 0) + 1
        }

        return calculateProfit(prizeCountMap).toDouble() / sunkCost
    }

    fun calculateProfit(prizeCountMap: Map<Int, Int>): Int {
        return Prize.values().sumOf {
            val count = prizeCountMap[it.matches] ?: 0
            OutputView.reportPrize(it.prizeMessage, count)
            count * it.prizeMoney
        }
    }
}
