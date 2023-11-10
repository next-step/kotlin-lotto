package lotto

import lotto.model.*
import lotto.view.InputView
import lotto.view.ResultView


class LottoOrganizer {

    fun start() {
        val ticketCount = LottoPerson.buyLottoTicket(InputView.getPurchasePrice())

        ResultView.renderTicketCount(ticketCount)

        val tickets = LottoGenerator.generateTickets(ticketCount) { this.shuffled() }

        ResultView.renderTickets(tickets)

        val results = LottoResults(tickets, InputView.getWinningNumbers().map { LottoNumber.from(it) })

        ResultView.renderResults(
            results
        )
    }
}
