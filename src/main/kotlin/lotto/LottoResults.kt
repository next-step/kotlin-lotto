package lotto

data class LottoResults(
    private val _results: MutableList<LottoResult> = LottoRank.entries.map { LottoResult(it) }.toMutableList(),
) {
    val results: List<LottoResult>
        get() = _results

    fun counting(lottoResult: LottoResult): LottoResults {
        val results = _results.map { result ->
            when (result.lottoRank) {
                lottoResult.lottoRank -> result.plus()
                else -> result
            }
        }.toMutableList()
        return LottoResults(results)
    }

    fun computeProfitRate(price: Price): Double {
        return _results.sumOf { it.sum() }.toDouble() / price.value
    }
}
