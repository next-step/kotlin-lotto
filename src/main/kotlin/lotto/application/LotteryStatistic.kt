package lotto.application

import lotto.domain.Lotteries
import lotto.domain.Lotteries.Companion.flatten
import lotto.domain.Price

object LotteryStatistic {

    fun getPriceGroupedLotteries(lotteries: Lotteries): Map<Price, Lotteries> =
        lotteries.groupBy { it.price }

    fun getEarningRate(
        investment: Int,
        priceGroupedLotteries: Map<Price, Lotteries>
    ): Float {
        val profit = priceGroupedLotteries.values.flatten().sumOf { it.winnerPrize() }

        return profit.toFloat().div(investment)
    }
}
