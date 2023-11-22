package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinningNumber
import lotto.provider.ticket.LottoTicketsProvider
import lotto.provider.winningnumber.WinningNumberProvider

class MockInputView(
    private val budget: Int,
    private val winningNumberProvider: WinningNumberProvider,
    private val lottoTicketsProvider: LottoTicketsProvider,
) : InputView {
    override fun provideBudget(): Int = budget

    override fun provideWinningNumber(): WinningNumber = winningNumberProvider.provide()

    override fun provideLottoTickets(ticketCount: Int): LottoTickets = lottoTicketsProvider.provide(ticketCount)
}
