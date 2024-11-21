package lotto.statistics

object ProfitCalculator {
    fun evaluate(winningAmount: Int, purchaseAmount: Int): Double = roundToTwoDecimal(winningAmount / purchaseAmount.toDouble())

    private fun roundToTwoDecimal(value: Double): Double = (value * 100).toInt() / 100.0
}
