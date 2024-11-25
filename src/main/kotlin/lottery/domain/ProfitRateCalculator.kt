package lottery.domain

object ProfitRateCalculator {
    fun calculate(
        purchaseAmount: Money,
        drawResult: DrawResult,
    ): Double {
        return drawResult.getTotalReward().divideBy(purchaseAmount)
    }
}
