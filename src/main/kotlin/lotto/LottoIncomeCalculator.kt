package lotto

import kotlin.math.floor

class LottoIncomeCalculator : IncomeCalculator {
    override fun calculate(
        inputMoney: Money,
        winningMoney: Money,
    ): IncomeRate {
        if (winningMoney == Money.ZERO) {
            return IncomeRate(ZERO_RATE)
        }
        val rate = calculateRate(inputMoney, winningMoney)

        return IncomeRate(rate)
    }

    private fun calculateRate(
        inputMoney: Money,
        winningMoney: Money,
    ): Double {
        return floor((winningMoney.toDouble() / inputMoney.toDouble()) * 100) / 100
    }

    companion object {
        private const val ZERO_RATE = 0.0
    }
}
