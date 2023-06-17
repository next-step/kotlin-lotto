package domain

import view.OutputView

class Settlement(private val winningNums: List<Int>) {

    fun getReturnOnInvestment(
        lotteries: List<Lottery>,
        sunkCost: Int,
        bonusNum: Int = -1
    ): Double {
        val prizeCountMap = mutableMapOf<Prize, Int>()

        for (lottery in lotteries) {
            val prize = lottery.getPrizeByLottery(winningNums, bonusNum) ?: continue
            prizeCountMap[prize] = (prizeCountMap[prize] ?: 0) + 1
        }

        for (it in Prize.values()) {
            OutputView.announcePrize(it.prizeMessage, prizeCountMap[it] ?: 0)
        }

        return calculateProfit(prizeCountMap).toDouble() / sunkCost
    }

    fun calculateProfit(prizeCountMap: Map<Prize, Int>): Int {
        return prizeCountMap.entries.sumOf { (key, value) ->
            value * key.prizeMoney
        }
    }
}
