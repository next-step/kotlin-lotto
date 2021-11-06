package lotto.domain

@JvmInline
value class LottoResults private constructor(private val lottoResults: List<LottoResult>) {

    fun getResults(): List<LottoResult> = lottoResults.toList()

    companion object {
        fun matchingWinningNumber(
            winningLottoNumber: LottoNumbers,
            bonusLottoNumber: LottoNumber,
            purchasedLottos: Lottos
        ): LottoResults {

            val matchingWinningNumbers: List<MatchingWinningNumber> = purchasedLottos.toList().map {
                MatchingWinningNumber.of(it.getLottoNumbers(), winningLottoNumber, bonusLottoNumber)
            }

            val lottoResults = LottoPrize.getPrizes().map {
                LottoResult.decideLottoPrize(it, matchingWinningNumbers)
            }
            return LottoResults(lottoResults)
        }
    }
}
