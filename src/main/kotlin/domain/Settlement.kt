package domain

import view.OutputView

class Settlement(private val winningNums: List<Int>) {

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
        var profit = 0

        for (idx in 3..6) {
            val count = prizeCountMap[idx] ?: 0
            val prize = Prize.getPrizeForMatches(idx)
            OutputView.announcePrize(idx, prize, count)
            profit += count * prize
        }

        return profit
    }
}
