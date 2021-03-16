package lotto.math

fun Double.roundTo(n: Int): Double {
    return "%.${n}f".format(this).toDouble()
}

fun getProfit(beforeMoney: Int, nowMoney: Int): Double = nowMoney.toDouble() / beforeMoney
