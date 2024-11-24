package lotto.domain

fun interface ProfitRateCalculator {
    fun calculate(
        totalPrize: Int,
        lottoPurchaseAmount: LottoPurchaseAmount,
    ): Double
}
