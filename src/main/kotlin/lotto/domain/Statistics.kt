package lotto.domain

object Statistics {

    fun action(prizeAllMoney: Int, lottoBuyMoney: Int): Double = prizeAllMoney.toDouble() / lottoBuyMoney.toDouble()
}
