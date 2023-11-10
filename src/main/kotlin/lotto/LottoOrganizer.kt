package lotto

import lotto.collection.LottoNumber
import lotto.collection.LottoResults
import lotto.collection.LottoTicket
import lotto.model.LottoGenerator
import lotto.view.InputView
import lotto.view.ResultView


class LottoOrganizer {

    fun start() {
        getTicketCount().let { ResultView.renderTicketCount(it) }
            .let { LottoGenerator.generateTickets(it) { this.shuffled() } }
            .let { ResultView.renderTickets(it) }.let(validateTickets).let {
                ResultView.renderResults(
                    it
                )
            }
    }

    private fun getTicketCount(): Int = InputView.getPurchasePrice() / LottoTicket.TICKET_PRICE

    private val validateTickets = { lottoTickets: List<LottoTicket> ->
        LottoResults(
            lottoTickets,
            InputView.getWinningNumbers().map { LottoNumber.from(it) })
    }

}
