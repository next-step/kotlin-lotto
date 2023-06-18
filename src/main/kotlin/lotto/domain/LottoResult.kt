package lotto.domain

data class LottoResult(val matchCount: Int, val prize: Int, val count: Int)

data class LottoResults(private val results: List<LottoResult>, val rateOfReturn: Double) : Iterable<LottoResult> {

    override fun iterator(): Iterator<LottoResult> {
        return results.iterator()
    }

    companion object {
        fun of(resultMap: Map<WinningPrize, Int>, purchaseAmount: Int): LottoResults {
            val results = WinningPrize.values().reversed()
                .map { LottoResult(it.count, it.prize, resultMap.getOrDefault(it, 0)) }
            val rate = resultMap.entries.sumOf { it.key.prize * it.value }.toDouble() / purchaseAmount

            return LottoResults(results, rate)
        }
    }
}
