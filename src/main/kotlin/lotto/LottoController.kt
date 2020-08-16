package lotto

import lotto.domain.LottoResult
import lotto.domain.WinningTicket
import lotto.view.LottoInputView
import lotto.view.LottoResultView

class LottoController {
    fun start(inputView: LottoInputView): LottoResult {
        val cost = inputView.inputTicketCost()
        val tickets = TicketBuilder.sellTickets(cost)

        inputView.printTickets(tickets)

        val winningTicket = WinningTicket(inputView.inputWinningTicket(), inputView.inputBonusNumber())
        return LottoResult(tickets, winningTicket)
    }

    fun finish(resultView: LottoResultView, result: LottoResult) {
        resultView.printResult(result)
    }
}
