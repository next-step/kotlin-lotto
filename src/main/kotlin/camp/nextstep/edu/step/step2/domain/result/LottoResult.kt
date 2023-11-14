package camp.nextstep.edu.step.step2.domain.result

data class LottoResult(
    val lottoTotalPrice: Int,
    val lottoResults: List<LottoMatch>
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

}
