package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class Profit(private val earnings: Int) {
    fun calculateProfitRatio(payment: Payment): BigDecimal {
        val moneyPaid = payment.money.toDouble()
        return BigDecimal(earnings / moneyPaid).setScale(2, RoundingMode.DOWN)
    }
}
