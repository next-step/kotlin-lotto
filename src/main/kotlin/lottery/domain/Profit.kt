package lottery.domain

object Profit {
    fun calculate(inputMoney: Int, jackpots: Int): String {
        return (jackpots.toDouble() / inputMoney.toDouble()).format(2)
    }

    private fun Double.format(digits: Int) = "%.${digits}f".format(this)
}
