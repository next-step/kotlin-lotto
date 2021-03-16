package lottery.domain

object Profit {
    fun calculate(inputMoney: Double, jackpots: Double): String {
        return (jackpots / inputMoney).format(2)
    }

    private fun Double.format(digits: Int) = "%.${digits}f".format(this)
}
