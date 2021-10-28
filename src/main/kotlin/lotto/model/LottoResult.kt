package lotto.model

import kotlin.math.floor

class LottoResult(
    lottoList: List<Lotto>,
    winLottoNumbers: LottoNumbers
) {
    private val winnersByRank: Map<LottoRank, Int> = makeWinnersByRank(lottoList, winLottoNumbers)
    val rateOfReturn: Float = makeRateOfReturn(lottoList)

    private fun makeWinnersByRank(
        lottoList: List<Lotto>,
        winLottoNumbers: LottoNumbers
    ): Map<LottoRank, Int> {
        val winnersByRank = mutableMapOf<LottoRank, Int>()
        lottoList.forEach { lotto ->
            val rank: LottoRank? = when (lotto.match(winLottoNumbers)) {
                RANK_MATCH_FIRST -> LottoRank.First
                RANK_MATCH_SECOND -> LottoRank.Second
                RANK_MATCH_THIRD -> LottoRank.Third
                RANK_MATCH_FOURTH -> LottoRank.Fourth
                RANK_MATCH_FIFTH -> LottoRank.Fifth
                else -> null
            }
            if (rank != null) {
                winnersByRank[rank] = winnersByRank.getOrDefault(rank, 0) + 1
            }
        }
        return winnersByRank
    }

    private fun makeRateOfReturn(lottoList: List<Lotto>): Float {
        if (winnersByRank.isEmpty()) {
            return 0f
        }
        val totalPrice = lottoList.sumOf { it.price }
        val totalWinnings = winnersByRank.map { (rank, count) -> rank.winnings * count }.sum()
        val rateOfReturn = (totalWinnings.toFloat() / totalPrice)
        return floor(rateOfReturn * 100) / 100
    }

    fun winners(rank: LottoRank): Int = winnersByRank.getOrDefault(rank, 0)

    companion object {
        private const val RANK_MATCH_FIRST = 6
        private const val RANK_MATCH_SECOND = 5
        private const val RANK_MATCH_THIRD = 4
        private const val RANK_MATCH_FOURTH = 3
        private const val RANK_MATCH_FIFTH = 2
    }
}
