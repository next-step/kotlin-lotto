package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinningNumber

interface InputView {
    fun provideBudget(): Int

    fun provideWinningNumber(): WinningNumber

    fun provideLottoTickets(): LottoTickets

    fun provideLottoPrice(): Int = 1000

    fun provideTicketCount(): Int = provideBudget() / provideLottoPrice()
}
