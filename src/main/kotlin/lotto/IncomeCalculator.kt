package lotto

fun interface IncomeCalculator {
    fun calculate(
        inputMoney: Money,
        winningMoney: Money,
    ): IncomeRate
}
