package lotto.domain

import java.util.EnumMap

@JvmInline
value class LottoResult(val value: EnumMap<LottoRank, Int> = EnumMap(LottoRank::class.java)) {
    init {
        LottoRank.values().forEach {
            value[it] = DEFAULT_COUNT
        }
    }

    fun add(lottoRank: LottoRank) {
        value[lottoRank] = value.getOrDefault(lottoRank, DEFAULT_COUNT) + INCREASE_COUNT
    }

    fun getLottoRankCount(lottoRank: LottoRank): Int {
        return value[lottoRank] ?: DEFAULT_COUNT
    }

    fun calculateProfitRate(amount: Int): Float {
        val totalWinningMoney = value.entries.sumOf { it.key.winningMoney * it.value }
        return totalWinningMoney.toFloat() / amount
    }

    companion object {
        private const val DEFAULT_COUNT = 0
        private const val INCREASE_COUNT = 1
    }
}
