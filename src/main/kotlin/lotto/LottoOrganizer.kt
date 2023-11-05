package lotto

import lotto.model.LottoGenerator
import lotto.model.LottoValidator
import lotto.view.InputView
import lotto.view.ResultView

class LottoOrganizer {

    fun start() {
        val tickets = LottoGenerator.generateTickets(InputView.getTicketCount(), TICKET_LENGTH, TICKET_RANGE)

        ResultView.renderTickets(tickets)

        ResultView.renderResults(
            ticketPrice = TICKET_PRICE,
            winningMoney = WINNING_MONEY_LIST,
            results = LottoValidator.validate(tickets, InputView.getWinningNumbers(TICKET_LENGTH), 6)
        )
    }

    companion object {
        const val TICKET_PRICE = 1000
        const val TICKET_LENGTH = 6
        val TICKET_RANGE = 1..45
        val WINNING_MONEY_LIST = listOf(0, 0, 0, 5000, 50000, 1500000, 2000000000)
    }
}
