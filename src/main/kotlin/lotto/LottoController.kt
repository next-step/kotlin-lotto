package lotto

import lotto.domain.TicketStore
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.inputMoney()

    val tickets = TicketStore.buyTickets(money)
    ResultView.printTickets(tickets)

    val winningTicket = InputView.inputWinningNumber()

    ResultView.printResults(tickets, winningTicket)

}

class LottoController {
}
