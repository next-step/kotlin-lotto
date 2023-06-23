package lotto.domain

data class LottoResult(val matchCount: Int, val bonusMatch: Boolean, val prize: Int, val count: Int)

data class WinLottoResults(private val results: List<LottoResult>, val rateOfReturn: Double) : Iterable<LottoResult> {

    override fun iterator(): Iterator<LottoResult> {
        return results.iterator()
    }

    companion object {
        fun of(resultMap: Map<WinningPrize, Int>, purchaseAmount: Int): WinLottoResults {
            val results = WinningPrize.values().filter { it != WinningPrize.NONE }.reversed()
                .map { LottoResult(it.count, it.bonusMatch, it.prize, resultMap.getOrDefault(it, 0)) }
            val rate = resultMap.entries.sumOf { it.key.prize * it.value }.toDouble() / purchaseAmount
            return WinLottoResults(results, rate)
        }
    }
}
