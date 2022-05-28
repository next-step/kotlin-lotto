package lotto.application

import lotto.domain.Lotteries
import lotto.domain.Lotto
import lotto.domain.Price

object LotteryAnnouncer {

    fun announce(winner: Lotto, bonusNumber: Int, lotteries: Lotteries): Map<Price, Lotteries> {
        return lotteries.groupBy {
            it.checkResult(winner, bonusNumber)
        }
    }

    fun getEarningRate(
        investment: Int,
        priceGroupedLotteries: Map<Price, Lotteries>
    ): Float {
        val profit = priceGroupedLotteries.map { entry -> entry.key.winningPrize * entry.value.count() }.sum()

        return profit.toFloat().div(investment)
    }
}
