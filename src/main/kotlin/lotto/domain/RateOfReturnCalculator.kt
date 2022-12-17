package lotto.domain

import lotto.common.Money
import java.math.BigDecimal
import java.math.RoundingMode

object RateOfReturnCalculator {

    fun calculate(paymentPrice: Money, prizeAmount: Money): BigDecimal {
        return (prizeAmount / paymentPrice).value.setScale(2, RoundingMode.FLOOR)
    }
}