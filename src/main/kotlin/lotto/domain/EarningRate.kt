package lotto.domain

import java.math.BigDecimal

class EarningRate(
    val strategy: (Double) -> BigDecimal
) {
    fun calculate(principal: Int, earn: Int): BigDecimal {
        return strategy(earn.toDouble()/principal.toDouble())
    }
}