package lotto.view

import lotto.domain.WinningNumber

interface InputView {
    fun provideBudget(): Int

    fun provideWinningNumbers(): WinningNumber
}
