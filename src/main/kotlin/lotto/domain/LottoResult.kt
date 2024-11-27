package lotto.domain

class LottoResult(
    private val statistics: Map<WinningCategory, Int>,
    private val totalPrize: Int,
    private val purchaseAmount: Int,
) {
    fun getStatistics(): Map<WinningCategory, Int> = statistics

    fun getProfitRate(): Double {
        return if (purchaseAmount > 0) {
            totalPrize.toDouble() / purchaseAmount
        } else {
            0.0
        }
    }
}
