package lotto.domain

class LottoGameResult(
    private val winningCountByAmount: LottoStatistics,
) {
    fun getRateOfReturn(purchasedPrice: Int): Float {
        val totalWinningAmount = winningCountByAmount.rank
            .entries
            .sumOf {
                (it.key.amount * it.value)
            }

        return totalWinningAmount.toFloat() / purchasedPrice.toFloat()
    }
}
