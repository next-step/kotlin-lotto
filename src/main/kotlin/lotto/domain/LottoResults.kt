package lotto.domain

@JvmInline
value class LottoResults private constructor(private val lottoResults: List<LottoResult>) {

    fun getResults(): List<LottoResult> = lottoResults.toList()

    companion object {
        fun matchingWinningNumber(
            winningNumber: List<Int>,
            bonusNumber: Int,
            purchasedLottos: List<Lotto>
        ): LottoResults {

            val matchingNumberAndIsBonusNumberPairs: List<Pair<Int, Boolean>> = purchasedLottos.map {
                it.matchingWinningNumber(winningNumber, bonusNumber)
            }

            val lottoResults: List<LottoResult> = LottoPrize.getPrizes().map {
                LottoResult.decideLottoPrize(it, matchingNumberAndIsBonusNumberPairs)
            }
            return LottoResults(lottoResults)
        }
    }
}
