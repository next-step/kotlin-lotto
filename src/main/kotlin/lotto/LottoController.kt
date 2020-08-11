package lotto

import lotto.domain.LottoAnalytics
import lotto.domain.LottoResult
import lotto.domain.TicketBuyer
import lotto.view.LottoResultView
import lotto.view.LottoInputView

class LottoController {
    fun start(inputView: LottoInputView, analytics: LottoAnalytics): LottoResult {
        val cost = inputView.inputTicketCost()
        val count = TicketBuyer.howMuchTickets(cost)
        val tickets = TicketBuilder.sellTickets(count)

        inputView.printTickets(tickets)

        val winner = inputView.inputWinnerTicket()
        return analytics.matchTickets(tickets, winner)
    }

    fun finish(resultView: LottoResultView, result: LottoResult) {
        resultView.printResult(result)
    }
}
