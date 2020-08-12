package lotto

import lotto.domain.LottoAnalytics
import lotto.domain.LottoResult
import lotto.view.LottoInputView
import lotto.view.LottoResultView

class LottoController {
    fun start(inputView: LottoInputView): LottoResult {
        val cost = inputView.inputTicketCost()
        val tickets = TicketBuilder.sellTickets(cost)

        inputView.printTickets(tickets)

        val winningTicket = inputView.inputwinningTicket()
        return LottoAnalytics.matchTickets(tickets, winningTicket)
    }

    fun finish(resultView: LottoResultView, result: LottoResult) {
        resultView.printResult(result)
    }
}
