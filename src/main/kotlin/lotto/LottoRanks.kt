package lotto

import java.math.BigDecimal

class LottoRanks {
    private val lottoRanks: MutableMap<LottoRank, Int> = mutableMapOf()

    init {
        lottoRanks[LottoRank.LOSE] = ZERO
        lottoRanks[LottoRank.THREE_MATCH] = ZERO
        lottoRanks[LottoRank.FOUR_MATCH] = ZERO
        lottoRanks[LottoRank.FIVE_MATCH] = ZERO
        lottoRanks[LottoRank.FIVE_MATCH_WITH_BONUS] = ZERO
        lottoRanks[LottoRank.SIX_MATCH] = ZERO
    }

    fun add(lottoRank: LottoRank) {
        lottoRanks[lottoRank] = lottoRanks.getOrDefault(lottoRank, ZERO) + 1
    }

    fun getRankCount(lottoRank: LottoRank): Int {
        return lottoRanks.getOrDefault(lottoRank, ZERO)
    }

    fun getRanks(): Map<LottoRank, Int> {
        return lottoRanks.toMap()
    }

    fun getWinPrice(): BigDecimal {
        return lottoRanks.entries
            .filter { it.value > ZERO }
            .sumOf { BigDecimal(it.key.price * it.value) }
    }

    companion object {
        private const val ZERO = 0
    }
}
