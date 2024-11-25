package lotto.domain

fun interface IncomeCalculator {
    fun calculate(
        inputMoney: Money,
        winningMoney: Money,
    ): IncomeRate
}
