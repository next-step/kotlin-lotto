package lotto.statistics

class Profit(
    private val winningAmount: Int,
    private val purchaseAmount: Int,
) {
    fun yield(): Double = roundToTwoDecimal(winningAmount / purchaseAmount.toDouble())

    private fun roundToTwoDecimal(value: Double): Double = (value * 100).toInt() / 100.0
}
