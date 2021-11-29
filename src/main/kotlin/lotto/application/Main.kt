package lotto.application

import lotto.domain.DashBoard
import lotto.domain.NumberStrategy
import lotto.domain.NumberStrategyImpl
import lotto.domain.TicketGenerator
import lotto.ui.InputView
import lotto.ui.ResultView

/**
 *
 * @author Leo
 */
fun main() {

    val inputView = InputView()
    val amount = inputView.getAmount()

    val ticketGenerator = TicketGenerator(NumberStrategyImpl(NumberStrategy.NUMBERS))
    val tickets = ticketGenerator.tickets(amount.toInt())
    inputView.showTicketCount(tickets)

    val winningNumbers = inputView.getWinningNumbers()

    val resultView = ResultView()
    val dashBoard = DashBoard()
    val result = dashBoard.result(winningNumbers, tickets)
    val prize = dashBoard.earnings(result, amount.toInt())
    resultView.showResult(result)
    resultView.showEarnings(prize)

}
