package lotto.domain

class PurchasedLottos(
    private val purchaseAmount: Won,
    manualLottoNumbers: List<ManualLottoNumbers>,
    lottoNumberGenerator: LottoNumberGenerator,
) {
    val lottos: List<Lotto> = LottoShop(lottoNumberGenerator).purchaseLottos(purchaseAmount, manualLottoNumbers)

    fun draw(winningNumbers: WinningNumbers, bonusNumber: LottoNumber): WinningStatistic {
        val prizes = lottos.mapNotNull {
            val matchedNumberCount = it.getMatchedNumberCount(winningNumbers)
            val bonusNumberMatch = it.isBonusNumberMatch(bonusNumber)

            Prize.valueOfOrNull(matchedNumberCount, bonusNumberMatch)
        }

        return WinningStatistic(
            prizes = prizes,
            purchaseAmount = purchaseAmount,
        )
    }
}
