package lottery.domain

object ProfitRateCalculator {
    fun calculate(
        purchaseAmount: Money,
        drawResult: DrawResult,
    ): Double {
        val totalPrize = drawResult.getTotalReward()
        return totalPrize.divideBy(purchaseAmount)
    }
}
