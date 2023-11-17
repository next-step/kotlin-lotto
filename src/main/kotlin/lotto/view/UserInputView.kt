package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinningNumber
import lotto.provider.ticket.LottoTicketsProvider
import lotto.provider.winningnumber.WinningNumberProvider

class UserInputView(
    private val budget: Int,
    private val winningNumberProvider: WinningNumberProvider,
    private val lottoTicketsProvider: LottoTicketsProvider,
) : InputView {
    override fun provideBudget(): Int = budget

    override fun provideWinningNumber(): WinningNumber = winningNumberProvider.provide()

    override fun provideLottoTickets(ticketCount: Int): LottoTickets {
        val lottoTickets = lottoTicketsProvider.provide(ticketCount)

        println("$ticketCount 개를 구매했습니다.")
        lottoTickets.lottoTicketList.forEach { ticket ->
            println(
                ticket.lottoNumberList.map { number ->
                    number.value
                }
            )
        }

        return lottoTickets
    }
}
