package lotto.domain

@JvmInline
value class LottoResults private constructor(private val lottoResults: List<LottoResult>) {

    fun toList(): List<LottoResult> = lottoResults.toList()

    companion object {
        fun matchingWinningNumber(winningNumber: List<Int>, purchasedLottos: List<Lotto>): LottoResults {
            val lottoNumberIntersectCounts: List<Int> = purchasedLottos.map {
                it.toNumberList().intersect(winningNumber).count()
            }
            val lottoResults: List<LottoResult> = LottoPrize.toList().map {
                LottoResult.matchingNumber(it, lottoNumberIntersectCounts)
            }
            return LottoResults(lottoResults)
        }
    }
}
