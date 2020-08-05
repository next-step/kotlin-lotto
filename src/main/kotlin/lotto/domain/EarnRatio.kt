package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

object EarnRatio {

    fun calculate(useMoney: Int, totalPrize: Long): BigDecimal {
        val totalPrizeNumber = BigDecimal(totalPrize)
        val useMoneyNumber = BigDecimal(useMoney)
        return totalPrizeNumber.divide(useMoneyNumber, 2, RoundingMode.CEILING)
    }
}
