package lotto.domain

data class LottoResults(
    private val lottoResults: List<LottoResult>
) {
    fun get() = lottoResults.toList()
}

fun List<LottoResult>.toLottoResults() = LottoResults(this)
