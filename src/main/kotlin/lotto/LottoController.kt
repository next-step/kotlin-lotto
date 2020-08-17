package lotto

import lotto.domain.LottoResult
import lotto.domain.TicketBuilder
import lotto.domain.WinningTicket
import lotto.view.LottoInputView
import lotto.view.LottoResultView

class LottoController {
    fun start(inputView: LottoInputView): LottoResult {
        val cost = inputView.inputTicketCost()
        val ticketCount = TicketBuilder.howMuchTickets(cost)

        val manualCount = inputView.inputManualCount()
        val manualText = inputView.inputManualTickets(manualCount)

        val manualTickets = TicketBuilder.sellTicketsManually(manualText)
        val autoTickets = TicketBuilder.sellTickets(ticketCount - manualCount)

        inputView.printTickets(manualCount, autoTickets)

        val winningTicket = WinningTicket(inputView.inputWinningTicket(), inputView.inputBonusNumber())
        return LottoResult(manualTickets + autoTickets, winningTicket)
    }

    fun finish(resultView: LottoResultView, result: LottoResult) {
        resultView.printResult(result)
    }
}
