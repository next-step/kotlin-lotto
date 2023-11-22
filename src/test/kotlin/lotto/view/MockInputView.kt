package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinningNumber
import lotto.provider.ticket.LottoTicketsProvider

class MockInputView(
    private val budget: Int,
    private val winningNumber: WinningNumber,
    private val lottoTicketsProvider: LottoTicketsProvider,
) : InputView {
    override fun getBudget(): Int = budget

    override fun getWinningNumber(): WinningNumber = winningNumber

    override fun provideLottoTickets(ticketCount: Int): LottoTickets = lottoTicketsProvider.provide(ticketCount)
}
