package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinningNumber

interface InputView {
    fun provideBudget(): Int

    fun provideWinningNumber(): WinningNumber

    fun provideLottoTickets(ticketCount: Int): LottoTickets
}
