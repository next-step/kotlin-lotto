package lotto

interface IncomeCalculator {
    fun calculate(inputMoney: Money, winningMoney: Money): IncomeRate
}
