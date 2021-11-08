package lotto.model

import kotlin.math.floor

data class LottoResult(
    private val winnersByRank: Map<LottoRank, Int>,
    val rateOfReturn: Float,
) {

    fun winners(rank: LottoRank): Int = winnersByRank.getOrDefault(rank, 0)

    companion object {

        fun of(
            lottoList: List<Lotto>,
            winLottoNumbers: LottoNumbers,
            bonus: LottoNumber
        ): LottoResult {
            require(!winLottoNumbers.contains(bonus))
            val winnersByRank = makeWinnersByRank(lottoList, winLottoNumbers, bonus)
            val rateOfReturn = makeRateOfReturn(winnersByRank, lottoList)
            return LottoResult(
                winnersByRank = winnersByRank,
                rateOfReturn = rateOfReturn
            )
        }

        private fun makeWinnersByRank(
            lottoList: List<Lotto>,
            winLottoNumbers: LottoNumbers,
            bonus: LottoNumber
        ): Map<LottoRank, Int> {
            val winnersByRank = mutableMapOf<LottoRank, Int>()
            lottoList.forEach { lotto ->
                val rank = LottoRank.valueOf(
                    match = lotto.match(winLottoNumbers),
                    bonus = bonus in lotto
                )
                if (rank != null) {
                    winnersByRank[rank] = winnersByRank.getOrDefault(rank, 0) + 1
                }
            }
            return winnersByRank
        }

        private fun makeRateOfReturn(winnersByRank: Map<LottoRank, Int>, lottoList: List<Lotto>): Float {
            if (winnersByRank.isEmpty()) {
                return 0f
            }
            val totalPrice = lottoList.sumOf { it.price.value }
            val totalWinnings = winnersByRank.map { (rank, count) -> rank.winnings * count }.sum()
            val rateOfReturn = (totalWinnings.toFloat() / totalPrice)
            // 소수점 2자리 유지
            return floor(rateOfReturn * 100) / 100
        }
    }
}
