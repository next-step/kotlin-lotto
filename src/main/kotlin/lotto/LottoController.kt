package lotto

import lotto.domain.LottoAnalytics
import lotto.domain.LottoResult
import lotto.domain.TicketBuyer
import lotto.view.LottoResultView
import lotto.view.LottoStartView

class LottoController {
    fun start(startView: LottoStartView, analytics: LottoAnalytics): LottoResult {
        val cost = startView.inputTicketCost()
        val count = TicketBuyer.howMuchTickets(cost)
        val tickets = TicketBuilder.sellTickets(count)

        startView.printTickets(tickets)

        val winner = startView.inputWinnerTicket()
        return analytics.matchTickets(tickets, winner)
    }

    fun finish(resultView: LottoResultView, result: LottoResult) {
        resultView.printResult(result)
    }
}
