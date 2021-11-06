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
            val winningLotto = LottoNumbers.generateLottoNumbers(winningNumber)
            val bonusLottoNumber = LottoNumber(bonusNumber)

            val matchingWinningNumbers: List<MatchingWinningNumber> = purchasedLottos.map {
                MatchingWinningNumber.of(it.getLottoNumbers(), winningLotto, bonusLottoNumber)
            }

            val lottoResults = LottoPrize.getPrizes().map {
                LottoResult.decideLottoPrize(it, matchingWinningNumbers)
            }
            return LottoResults(lottoResults)
        }
    }
}
