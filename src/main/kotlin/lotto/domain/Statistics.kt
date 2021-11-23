package lotto.domain

object Statistics {

    fun calculation(prizeAllMoney: Int, lottoBuyMoney: Int): Double = prizeAllMoney.toDouble() / lottoBuyMoney.toDouble()
}
