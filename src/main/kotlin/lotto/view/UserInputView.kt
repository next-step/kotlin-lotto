package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinningNumber
import lotto.provider.ticket.LottoTicketsProvider
import lotto.provider.winningnumber.WinningNumberProvider

class UserInputView(
    private val winningNumberProvider: WinningNumberProvider,
    private val lottoTicketsProvider: LottoTicketsProvider,
) : InputView {
    private var budget: Int? = null

    override fun provideBudget(): Int {

        return budget ?: println("구입 금액을 입력하세요")
            .run {
                budget = readln().trim().toInt()
                budget!!
            }
    }

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

    override fun provideLottoPrice(): Int = lottoTicketsProvider.provideLottoPrice()
}
