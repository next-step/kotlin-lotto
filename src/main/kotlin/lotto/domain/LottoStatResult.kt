package lotto.domain

import kotlin.math.round

class LottoStatResult(
    lottoStat: Map<Rank, Int> = Rank.values().associateBy({ it }, { DEFAULT_COUNT })
) {
    private val lottoStat = lottoStat.toMutableMap()

    fun getCount(rank: Rank): Int = lottoStat.getOrDefault(rank, DEFAULT_COUNT)

    fun addCount(rank: Rank) {
        lottoStat[rank] = getCount(rank) + 1
    }

    fun getReturnRate(): Double {
        val totalReward =
            lottoStat.toList().fold(DEFAULT_REWARD) { fold, next -> fold + (next.first.winningMoney * next.second) }

        return round(totalReward / (getCountOfLotto() * LottoMachine.LOTTO_PRICE).toDouble() * 100) / 100
    }

    private fun getCountOfLotto(): Int = lottoStat.values.sum()

    companion object {
        const val DEFAULT_COUNT = 0
        const val DEFAULT_REWARD = 0
    }
}
