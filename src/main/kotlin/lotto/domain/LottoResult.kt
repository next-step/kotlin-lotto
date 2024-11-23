package lotto.domain

import lotto.domain.Lotto.Companion.NUMBER_OF_NUMBER

class LottoResult(
    val lottos: List<Lotto>,
    val lottoResultMap: Map<Int, Int>,
    val profitRate: Double,
) {
    companion object {
        fun getResultMap(
            lottos: List<Lotto>,
            winningNumbers: WinningNumbers,
        ): Map<Int, Int> {
            val matchCounts = lottos.map { winningNumbers.matchNumbers(it) }
            val pairs = List(NUMBER_OF_NUMBER + 1) { it }.map { Pair(it, getNumberCount(matchCounts, it)) }
            return pairs.map { it.first to it.second }.toMap()
        }

        private fun getNumberCount(
            numbers: List<Int>,
            matchNumber: Int,
        ): Int {
            return numbers.filter { it == matchNumber }.size
        }
    }
}
