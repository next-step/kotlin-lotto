package lotto.domain.strategy

import lotto.domain.Money
import lotto.domain.ProfitRate

fun interface ProfitCalculator {
    fun calculate(inputMoney: Money, winningAmount: Money): ProfitRate
}
