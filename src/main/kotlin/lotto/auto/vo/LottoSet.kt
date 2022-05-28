package lotto.auto.vo

import lotto.auto.domain.Lotto

class LottoSet(private val lottos: List<Lotto>) : List<Lotto> by lottos {

    fun countPlace(winningLottery: Lotto, place: LottoScore): Int =
        lottos.count { it.match(winningLottery) == place }

    fun groupPlace(winningLottery: Lotto): Map<LottoScore, Int> =
        lottos.map { it.match(winningLottery) }.groupingBy { it }.eachCount()

    fun rate(winningLottery: Lotto): Double =
        totalRewardMoney(winningLottery)
            .div(totalCost())
            .toDouble()

    private fun totalCost(): Int = lottos.size * Lotto.PRICE

    private fun totalRewardMoney(winningLottery: Lotto): Int =
        groupPlace(winningLottery)
            .entries
            .sumOf { (rank, count) ->
                rank.rewardMoney * count
            }
}
