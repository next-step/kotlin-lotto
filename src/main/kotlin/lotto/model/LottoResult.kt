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
            val rank = LottoRank.find(lotto.match(winLottoNumbers))
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
}
