package camp.nextstep.edu.step.step2

import camp.nextstep.edu.step.step2.domain.store.LottoStore
import camp.nextstep.edu.step.step2.view.InputView
import camp.nextstep.edu.step.step2.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val buyAmount = inputView.getInputValueAndReturnBuyAmount()
    val tickets = LottoStore.buyLottoTickets(buyAmount = buyAmount)

    val ticketsNumbers = tickets.createNumbersByLottoTicketAmount()

    outputView.displayTicketsNumbers(
        lottoTickets = tickets,
        ticketNumbers = ticketsNumbers
    )

    val lastWeekWinningNumbers = inputView.inputLastWeekWinningNumbers()

    val lottoResult = LottoStore.checkLottoTicketsWinningResult(
        lottoNumbers = ticketsNumbers,
        lastWeekNumbers = lastWeekWinningNumbers
    )

    outputView.displayLottoResult(lottoResult = lottoResult)
}
