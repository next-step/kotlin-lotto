package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

object EarnRatio {

    fun calculate(useMoney: LottoMoney, totalPrize: LottoMoney): BigDecimal {
        val totalPrizeNumber = totalPrize.value.toBigDecimal()
        val useMoneyNumber = useMoney.value.toBigDecimal()
        return totalPrizeNumber.divide(useMoneyNumber, 2, RoundingMode.CEILING)
    }
}
