package lotto.domain

@JvmInline
value class LottoResults private constructor(private val lottoResults: List<LottoResult>) {

    fun toList(): List<LottoResult> = lottoResults.toList()

    companion object {
        fun matchingWinningNumber(
            winningNumber: List<Int>,
            bonusNumber: Int,
            purchasedLottos: List<Lotto>
        ): LottoResults {

            val matchingNumberAndIsBonusNumberPairs: List<Pair<Int, Boolean>> = purchasedLottos.map {
                val lottoNumbers = it.toNumberList()
                Pair(lottoNumbers.intersect(winningNumber).count(), lottoNumbers.contains(bonusNumber))
            }

            val lottoResults: List<LottoResult> = LottoPrize.toList().map {
                LottoResult.matchingNumber(
                    it,
                    matchingNumberAndIsBonusNumberPairs
                )
            }
            return LottoResults(lottoResults)
        }
    }
}
