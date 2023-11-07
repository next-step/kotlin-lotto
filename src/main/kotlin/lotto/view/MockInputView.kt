package lotto.view

import lotto.domain.WinningNumber
import lotto.provider.budget.BudgetProvider
import lotto.provider.winningnumber.WinningNumberProvider

class MockInputView(
    private val budgetProvider: BudgetProvider,
    private val winningNumberProvider: WinningNumberProvider,
) : InputView {
    override fun provideBudget(): Int = budgetProvider.provide()

    override fun provideWinningNumbers(): WinningNumber = winningNumberProvider.provide()
}
