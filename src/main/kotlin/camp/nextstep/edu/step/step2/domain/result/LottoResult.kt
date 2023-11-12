package camp.nextstep.edu.step.step2.domain.result

data class LottoResult(
    private val lottoTotalPrice: Int,
    private val lottoResults: List<LottoMatch>
) {

    init {
        require(lottoTotalPrice > 0) { "로또의 총 금액은 0보다 커야합니다." }
    }

    fun calculateProfitRate(): Double {
        return lottoResults.sumOf { it.prize }.toDouble() / lottoTotalPrice
    }

    fun getResultCount(lottoMatch: LottoMatch): Int {
        return lottoResults.count { it == lottoMatch }
    }

    companion object {
        fun of(lottoTotalPrice: Int, lottoResults: List<LottoMatch>): LottoResult {
            return LottoResult(lottoTotalPrice, lottoResults)
        }
    }

}
