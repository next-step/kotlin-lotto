package lotto.domain

import kotlin.math.round

class LottoStatResult(
    lottoStat: Map<Rank, Int> = mapOf(
        *Rank.values().map { it to 0 }.toTypedArray()
    )
) {
    private val lottoStat = lottoStat.toMutableMap()

    fun getCount(rank: Rank): Int = lottoStat[rank] ?: 0

    fun addCount(rank: Rank) {
        lottoStat[rank] = getCount(rank) + 1
    }

    fun getReturnRate(): Double {
        val totalReward = lottoStat.toList().fold(0) { fold, next -> fold + (next.first.winningMoney * next.second) }

        return round(totalReward / (getCountOfLotto() * LottoMachine.LOTTO_PRICE).toDouble() * 100) / 100
    }

    private fun getCountOfLotto(): Int = lottoStat.map { it.value }.sum()
}
