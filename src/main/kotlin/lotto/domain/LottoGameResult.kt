package lotto.domain

class LottoGameResult(
    private val winningCountByAmount: LottoStatistics,
) {
    fun getRateOfReturn(purchasedPrice: Int): Double {
        val totalWinningAmount = winningCountByAmount.rank
            .entries
            .sumOf {
                (it.key.amount * it.value)
            }

        return totalWinningAmount.toDouble() / purchasedPrice.toDouble()
    }
}
