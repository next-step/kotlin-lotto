package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinningNumber

interface InputView {
    fun getBudget(): Int

    fun getWinningNumber(): WinningNumber

    fun provideLottoTickets(ticketCount: Int): LottoTickets
}
