package lotto.domain

class ProfitCalculator {
    fun calculateProfitRate(
        totalPrize: Int,
        purchaseAmount: Int,
    ): Double {
        return if (purchaseAmount > 0) {
            totalPrize.toDouble() / purchaseAmount
        } else {
            0.0
        }
    }
}
