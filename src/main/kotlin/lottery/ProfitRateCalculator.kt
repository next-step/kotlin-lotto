package lottery

object ProfitRateCalculator {
    fun calculate(
        purchaseAmount: Money,
        drawResult: DrawResult,
    ): Double {
        val totalPrize = drawResult.calculateTotalPrize()
        return totalPrize.divideBy(purchaseAmount)
    }
}
