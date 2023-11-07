package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinningNumber
import lotto.provider.budget.BudgetProvider
import lotto.provider.ticket.LottoTicketsProvider
import lotto.provider.winningnumber.WinningNumberProvider

class MockInputView(
    private val budgetProvider: BudgetProvider,
    private val winningNumberProvider: WinningNumberProvider,
    private val lottoTicketsProvider: LottoTicketsProvider,
) : InputView {
    override fun provideBudget(): Int = budgetProvider.provide()

    override fun provideWinningNumber(): WinningNumber = winningNumberProvider.provide()

    override fun provideLottoTickets(ticketCount: Int): LottoTickets = lottoTicketsProvider.provide(ticketCount)

    override fun provideLottoPrice(): Int = lottoTicketsProvider.provideLottoPrice()
}
