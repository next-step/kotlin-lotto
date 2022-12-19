package lotto.application

import lotto.common.value.Money
import java.math.BigDecimal
import java.math.RoundingMode

object RateOfReturnCalculator {

    fun calculate(paymentPrice: Money, prizeAmount: Money): BigDecimal {
        return (prizeAmount / paymentPrice).value.setScale(2, RoundingMode.FLOOR)
    }
}
