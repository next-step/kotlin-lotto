package lotto.domain.strategy

import kotlin.math.floor
import lotto.domain.Money
import lotto.domain.ProfitRate

object LottoProfitCalculator : ProfitCalculator {
    private val ZERO_PROFIT = ProfitRate(0.0)

    override fun calculate(inputMoney: Money, winningAmount: Money): ProfitRate = when (winningAmount) {
        Money.ZERO -> ZERO_PROFIT
        else -> (floor((winningAmount.toDouble() / inputMoney.toDouble()) * 100) / 100).let(::ProfitRate)
    }
}

private fun Money.toDouble(): Double = this.value.toDouble()
