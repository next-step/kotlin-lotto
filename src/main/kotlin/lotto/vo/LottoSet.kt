package lotto.vo

import lotto.domain.Lottery
import kotlin.math.roundToInt

class LottoSet<T>(private val lotteries: List<Lottery<T>>) : List<Lottery<T>> by lotteries {

    fun countPlace(winningNormalLottery: T, place: LottoScore): Int =
        lotteries.count { it.match(winningNormalLottery) == place }

    fun groupPlace(winningNormalLottery: T): Map<LottoScore, Int> =
        lotteries.map { it.match(winningNormalLottery) }.groupingBy { it }.eachCount()

    fun rate(winningNormalLottery: T): Double =
        totalRewardMoney(winningNormalLottery)
            .div(totalCost().toDouble())
            .times(100)
            .roundToInt()
            .div(100.0)

    private fun totalCost(): Int = lotteries.size * Lottery.PRICE

    private fun totalRewardMoney(winningNormalLottery: T): Int =
        groupPlace(winningNormalLottery)
            .entries
            .sumOf { (rank, count) ->
                rank.rewardMoney * count
            }
}
