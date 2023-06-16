package lotto.domain

data class LottoResult(val matchCount: Int, val prize: Int, val count: Int)

data class LottoResults(private val results: List<LottoResult>, val rateOfReturn: Double) : Iterable<LottoResult> {

    constructor(resultMap: Map<WinningPrize, Int>, purchaseAmount: Int) : this(
        WinningPrize.values().reversed()
            .map { LottoResult(it.count, it.prize, resultMap.getOrDefault(it, 0)) },
        resultMap.entries.sumOf { it.key.prize * it.value }.toDouble() / purchaseAmount
    )

    override fun iterator(): Iterator<LottoResult> {
        return results.iterator()
    }
}
