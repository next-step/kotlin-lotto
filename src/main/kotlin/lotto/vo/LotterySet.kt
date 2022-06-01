package lotto.vo

import lotto.domain.Lottery
import lotto.policy.LotteryPolicy
import kotlin.math.roundToInt

class LotterySet(private val lotteries: List<Lottery>) : List<Lottery> by lotteries {

    fun countPlace(lotteryPolicy: LotteryPolicy, place: LotteryRank): Int =
        lotteries.count { lotteryPolicy.match(it) == place }

    fun groupPlace(lotteryPolicy: LotteryPolicy): Map<LotteryRank, Int> =
        lotteries.map { lotteryPolicy.match(it) }.groupingBy { it }.eachCount()

    fun rate(lotteryPolicy: LotteryPolicy): Double =
        totalRewardMoney(lotteryPolicy)
            .div(totalCost().toDouble())
            .times(100)
            .roundToInt()
            .div(100.0)

    private fun totalCost(): Int = lotteries.size * Lottery.PRICE

    private fun totalRewardMoney(lotteryPolicy: LotteryPolicy): Int =
        groupPlace(lotteryPolicy)
            .entries
            .sumOf { (rank, count) ->
                rank.rewardMoney * count
            }
}
