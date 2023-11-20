package lotto.domain

import kotlin.math.round

class LottoStatResult(
    private val lottoStat: Map<Rank, Int> = Rank.values().associateBy({ it }, { DEFAULT_COUNT })
) {
    fun getCount(rank: Rank): Int = lottoStat.getOrDefault(rank, DEFAULT_COUNT)

    fun getReturnRate(): Double {
        val totalReward =
            lottoStat.toList().fold(DEFAULT_REWARD) { fold, next -> fold + (next.first.winningMoney * next.second) }

        return round(totalReward / (getCountOfLotto() * LottoMachine.LOTTO_PRICE).toDouble() * 100) / 100
    }

    private fun getCountOfLotto(): Int = lottoStat.values.sum()

    companion object {
        private const val DEFAULT_COUNT = 0
        private const val DEFAULT_REWARD = 0
    }
}
