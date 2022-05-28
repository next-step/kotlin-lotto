package lotto.application

import lotto.domain.Lotteries
import lotto.domain.Lotto
import lotto.domain.Price

object LotteryAnnouncer {

    fun announce(winner: Lotto, lotteries: Lotteries): Map<Price, Lotteries> {
        return lotteries.groupBy {
            checkLotteryResult(winner.correctNumberCounts(it))
        }
    }

    fun getEarningRate(
        investment: Int,
        priceGroupedLotteries: Map<Price, Lotteries>
    ): Float {
        val profit = priceGroupedLotteries.map { entry -> entry.key.winningPrize * entry.value.count() }.sum()

        return profit.toFloat().div(investment)
    }

    private fun checkLotteryResult(correctedNumberCounts: Int): Price {
        return when (correctedNumberCounts) {
            6 -> Price.FIRST
            5 -> Price.SECOND
            4 -> Price.THIRD
            3 -> Price.FOURTH
            else -> Price.NONE
        }
    }
}
