package lotto.vo

import lotto.domain.Lottery
import kotlin.math.roundToInt

class LottoSet(private val lotteries: List<Lottery>) : List<Lottery> by lotteries {

    fun countPlace(winningLottery: Lottery, place: LottoScore): Int =
        lotteries.count { it.match(winningLottery) == place }

    fun groupPlace(winningLottery: Lottery): Map<LottoScore, Int> =
        lotteries.map { it.match(winningLottery) }.groupingBy { it }.eachCount()

    fun rate(winningLottery: Lottery): Double =
        totalRewardMoney(winningLottery)
            .div(totalCost().toDouble())
            .times(100)
            .roundToInt()
            .div(100.0)

    private fun totalCost(): Int = lotteries.size * Lottery.PRICE

    private fun totalRewardMoney(winningLottery: Lottery): Int =
        groupPlace(winningLottery)
            .entries
            .sumOf { (rank, count) ->
                rank.rewardMoney * count
            }
}
