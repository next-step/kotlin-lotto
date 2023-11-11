package lotto.domain

class LottoResult(private val userLotto: List<Lotto>, private val winningLotto: Lotto) {
    val ranks: Map<LottoRank, List<Lotto>> = calculateRanks()

    fun getLottosOfRank(rank: LottoRank): List<Lotto> {
        return ranks[rank] ?: emptyList()
    }

    private fun calculateRanks(): Map<LottoRank, List<Lotto>> {
        return userLotto.groupBy { lotto ->
            val matchCount = lotto.match(winningLotto)
            LottoRank.getRank(matchCount)
        }
    }
}
