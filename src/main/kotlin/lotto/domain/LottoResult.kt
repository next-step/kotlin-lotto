package lotto.domain

import kotlin.math.floor

class LottoResult(private val userLotto: List<Lotto>, private val winningLotto: Lotto) {
    val ranks: Map<LottoRank, List<Lotto>> = calculateRanks()

    fun getLottosOfRank(rank: LottoRank): List<Lotto> {
        return ranks[rank] ?: emptyList()
    }

    fun calculateProfitRate(): Double {
        val totalCost = userLotto.size * Lotto.LOTTO_PRICE
        val totalPrize = ranks.entries.sumOf { (rank, lottos) -> lottos.size * rank.prize }

        val profitRate = totalPrize.toDouble() / totalCost.toDouble()
        return floor(profitRate * 100) / 100
    }

    private fun calculateRanks(): Map<LottoRank, List<Lotto>> {
        return userLotto.groupBy { lotto ->
            val matchCount = lotto.match(winningLotto)
            LottoRank.getRank(matchCount)
        }
    }
}
