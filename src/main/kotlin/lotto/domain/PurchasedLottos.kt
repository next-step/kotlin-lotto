package lotto.domain

class PurchasedLottos(
    val lottos: List<Lotto>,
    private val purchaseAmount: Long,
) {
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
