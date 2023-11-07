package lotto.view

import lotto.domain.WinningNumber

class MockInputView(
    private val budget: Int,
    private val winningNumber: WinningNumber,
) : InputView {
    override fun provideBudget(): Int = budget

    override fun provideWinningNumbers(): WinningNumber = winningNumber
}
