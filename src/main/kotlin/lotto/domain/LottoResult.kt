package lotto.domain

class LottoResult(private val userLotto: List<Lotto>, private val winningLotto: Lotto) {
    private val ranks: Map<LottoRank, List<Lotto>> = calculateRanks()

    fun getLottosOfRank(rank: LottoRank): List<Lotto> {
        return ranks[rank] ?: emptyList()
    }

    fun calculateProfitRate(): Double {
        val totalCost = userLotto.size * Lotto.LOTTO_PRICE
        val totalPrize = ranks.entries.sumOf { (rank, lottos) -> lottos.size * rank.prize }

        return totalPrize.toDouble() / totalCost.toDouble()
    }

    private fun calculateRanks(): Map<LottoRank, List<Lotto>> {
        return userLotto.groupBy { lotto ->
            val matchCount = lotto.match(winningLotto)
            LottoRank.getRank(matchCount)
        }
    }
}
