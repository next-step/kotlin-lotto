package lotto.domain

import lotto.domain.enums.LottoRank

class LottoMatchReport(
    val matchingMap: Map<LottoRank, Int>,
    val rateOfReturn: Double
) {
    fun matchingCountBy(lottoRank: LottoRank): Int {
        return matchingMap.getOrDefault(lottoRank, 0)
    }

    companion object {
        fun of(winningLotto: WinningLotto, lottoList: List<Lotto>): LottoMatchReport {
            val matchingMap = lottoList
                .map { Pair(winningLotto.matchingNumbers(it), winningLotto.isMatchBonusNumber(it)) }
                .groupingBy { LottoRank.of(it.first.size, it.second) }
                .eachCount()
            val revenue = revenue(matchingMap)
            val rateOfReturn = rateOfReturn(revenue, lottoList.size)
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
