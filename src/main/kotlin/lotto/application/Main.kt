package lotto.application

import lotto.domain.*
import lotto.ui.InputView
import lotto.ui.ResultView

/**
 *
 * @author Leo
 */
fun main() {

    val inputView = InputView()
    val amount = inputView.getAmount()

    val ticketGenerator = TicketGenerator(RandomNumberStrategy(NumberStrategy.NUMBERS))
    val allTicket = Tickets(ticketGenerator.tickets(amount.toInt()))
    inputView.showTicketCount(allTicket.tickets)

    val winningNumbers = inputView.getWinningNumbers()

    val resultView = ResultView()
    val dashBoard = DashBoard()
    val result = allTicket.result(winningNumbers)
    val prize = dashBoard.earnings(result, amount.toInt())
    resultView.showResult(result)
    resultView.showEarnings(prize)

}
