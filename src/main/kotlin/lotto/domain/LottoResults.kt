package lotto.domain

@JvmInline
value class LottoResults private constructor(private val lottoResults: List<LottoResult>) {

    fun getResults(): List<LottoResult> = lottoResults.toList()

    companion object {
        fun matchingWinningNumber(
            winningLottoNumbers: LottoNumbers,
            bonusLottoNumber: LottoNumber,
            purchasedLottos: Lottos
        ): LottoResults {

            val matchingWinningNumbers: List<MatchingWinningNumber> =
                purchasedLottos.toMatchingWinningNumbers(winningLottoNumbers, bonusLottoNumber)

            val lottoResults = LottoPrize.getPrizes().map {
                LottoResult.decideLottoPrize(it, matchingWinningNumbers)
            }
            return LottoResults(lottoResults)
        }
    }
}
