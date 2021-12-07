package lotto.domain

import kotlin.math.floor

object Statistics {

    fun calculation(prizeAllMoney: Int, lottoBuyMoney: Int): Double =
        floor((prizeAllMoney.toDouble() / lottoBuyMoney.toDouble()) * 100) / 100
}
