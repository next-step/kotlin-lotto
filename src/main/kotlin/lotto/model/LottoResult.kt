package lotto.model

class LottoResult(
    lottoList: List<Lotto>,
    winLottoNumbers: LottoNumbers
) {
    private val winnersByRank: Map<LottoRank, Int> = makeWinnersByRank(lottoList, winLottoNumbers)

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
                RANK_MATCH_Fifth -> LottoRank.Fifth
                else -> null
            }
            if (rank != null) {
                winnersByRank[rank] = winnersByRank.getOrDefault(rank, 0) + 1
            }
        }
        return winnersByRank
    }

    fun winners(rank: LottoRank): Int = winnersByRank.getOrDefault(rank, 0)

    companion object {
        private const val RANK_MATCH_FIRST = 6
        private const val RANK_MATCH_SECOND = 5
        private const val RANK_MATCH_THIRD = 4
        private const val RANK_MATCH_FOURTH = 3
        private const val RANK_MATCH_Fifth = 2
    }
}
