package lotto.domain.strategy

import lotto.domain.Money
import kotlin.math.floor

private const val ZERO_PROFIT = 0.0

object LottoProfitCalculator : ProfitCalculator {
    override fun calculate(inputMoney: Money, winningAmount: Money): Double {
        if (winningAmount == Money.ZERO) {
            return ZERO_PROFIT
        }

        return floor((inputMoney.toDouble() / winningAmount.toDouble()) * 100) / 100
    }
}

private fun Money.toDouble(): Double = this.value.toDouble()
