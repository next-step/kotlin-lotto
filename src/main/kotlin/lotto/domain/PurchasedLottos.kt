package lotto.domain

class PurchasedLottos(
    val lottos: List<Lotto>,
    private val purchaseAmount: Long,
) {
    fun draw(winningNumbers: WinningNumbers): WinningStatistic {
        val prizes = lottos.mapNotNull {
            val matchedNumberCount = it.getMatchedNumberCount(winningNumbers)
            Prize.valueOfOrNull(matchedNumberCount)
        }

        return WinningStatistic(
            prizes = prizes,
            purchaseAmount = purchaseAmount,
        )
    }
}
