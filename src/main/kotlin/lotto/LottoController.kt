package lotto

import lotto.domain.TicketStore
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.inputMoney()

    val tickets = TicketStore.buyTickets(money)
    ResultView.printTickets(tickets)

    val numbers = InputView.inputWinningNumber()


    val winningTicket = TicketStore.createWinningTicket(numbers);

    val awardResults = tickets.awardResults(winningTicket);
    ResultView.printResults(awardResults)

}

class LottoController {
}
