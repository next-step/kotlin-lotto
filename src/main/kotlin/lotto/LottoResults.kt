package lotto

data class LottoResults(
    private val _results: List<LottoResult> = LottoRank.entries.map { LottoResult(lottoRank = it) }.toMutableList()
) {
    val results: List<LottoResult>
        get() = _results

    fun counting(lottoResult: LottoResult) {
        _results.find { it.lottoRank == lottoResult.lottoRank }?.count()
    }

    fun computeProfitRate(price: Price): Double {
        return results.sumOf { it.sum() }.toDouble() / price.value
    }
}