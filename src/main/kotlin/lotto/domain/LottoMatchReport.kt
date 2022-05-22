package lotto.domain

import lotto.domain.enums.LottoRank

class LottoMatchReport(
    private val matchingMap: Map<LottoRank, Int>,
    val rateOfReturn: Double
) {
    fun matchingCountBy(lottoRank: LottoRank): Int {
        return matchingMap.getOrDefault(lottoRank, 0)
    }

    companion object {
        fun of(lottoRanks: List<LottoRank>): LottoMatchReport {
            val matchingMap = lottoRanks.groupingBy { it }.eachCount()
            val revenue = revenue(matchingMap)
            val rateOfReturn = rateOfReturn(revenue, lottoRanks.size)
            return LottoMatchReport(matchingMap, rateOfReturn)
        }

        private fun rateOfReturn(revenue: Long, numberOfLotto: Int): Double {
            val totalPrice = LottoSeller.LOTTO_PRICE * numberOfLotto
            return revenue.toDouble() / totalPrice.toDouble()
        }

        private fun revenue(matchingMap: Map<LottoRank, Int>): Long {
            return matchingMap
                .entries
                .sumOf { (lotteRank, count) -> lotteRank.sumOfPrice(count) }
        }
    }
}
