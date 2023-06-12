package lotto.domain.strategy

import lotto.domain.Money

fun interface ProfitCalculator {
    fun calculate(inputMoney: Money, winningAmount: Money): Double
}
