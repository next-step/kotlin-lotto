package lotto.domain

class LottoResults(
    private val values: Map<LottoResult, Int>
) {
    fun countOf(lottoResult: LottoResult): Int {
        return values[lottoResult] ?: 0
    }

    fun getTotalPrize(): Long {
        return values.map { calculatePrizeOf(it) }.sum()
    }

    private fun calculatePrizeOf(element: Map.Entry<LottoResult, Int>): Long {
        return element.key.prize * element.value
    }
}
