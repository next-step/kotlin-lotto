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
    val allTicket = ticketGenerator.tickets(amount.toInt())
    inputView.showTicketCount(allTicket.tickets)

    val winningNumbers = WinningNumber(inputView.getWinningNumbers(), inputView.getBonusNumber().toInt())

    val resultView = ResultView()
    val dashBoard = DashBoard()
    val result = allTicket.result(winningNumbers.numbers, winningNumbers.bonusNumber)
    val prize = dashBoard.earnings(result, amount.toInt())
    resultView.showResult(result)
    resultView.showEarnings(prize)

}
