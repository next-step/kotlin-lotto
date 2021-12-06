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
    val manualCount = inputView.getManualTicketCount()
    val manualTicketNumbers = inputView.getManualTicketNumbers(manualCount.toInt())
    val manualTickets = Tickets(manualTicketNumbers.map { Ticket(it) })

    val ticketGenerator = TicketGenerator(RandomNumberStrategy(NumberStrategy.NUMBERS))
    val allTicket = ticketGenerator.tickets(amount, manualTickets)
    inputView.showTicketCount(allTicket.tickets, manualCount)

    val winningNumbers = WinningNumber(inputView.getWinningNumbers(), inputView.getBonusNumber().toInt())

    val resultView = ResultView()
    val result = allTicket.result(winningNumbers.numbers, winningNumbers.bonusNumber)
    val prize = allTicket.earnings(result, amount)
    resultView.showResult(result)
    resultView.showEarnings(prize)

}
