package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class Profit(private val profit: Int) {
    fun getProfitRatio(payment: Payment): BigDecimal {
        val payment = payment.money
        return BigDecimal(profit / payment.toDouble()).setScale(2, RoundingMode.DOWN)
    }
}
