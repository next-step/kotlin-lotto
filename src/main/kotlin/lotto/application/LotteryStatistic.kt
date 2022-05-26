package lotto.application

import lotto.domain.Lotto
import lotto.domain.Price

object LotteryStatistic {

    fun getPriceGroupedLotteries(lotteries: List<Lotto>): Map<Price, List<Lotto>> =
        lotteries.groupBy { it.price }.toMap()

    fun getEarningRate(
        investment: Int,
        priceGroupedLotteries: Map<Price, List<Lotto>>
    ): Float {
        val profit = priceGroupedLotteries.values.flatten().sumOf { it.winnerPrize() }

        return profit.toFloat().div(investment)
    }
}
