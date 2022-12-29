package lotto.controller

import lotto.model.AutomaticLottoTicketGenerator
import lotto.model.LottoTicket
import lotto.model.ManualLottoTicketGenerator
import lotto.model.TicketQuantity
import lotto.model.WinningCalculator
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun start() {
        val totalQuantity = TicketQuantity(inputView.getAmountOfMoney()).quantity
        val manualTicketQuantity = inputView.getManualQuantity().toInt()
        val automaticTicketQuantity = totalQuantity - manualTicketQuantity
        outputView.showQuantity(manualTicketQuantity, automaticTicketQuantity)

        val lottoTickets =
            generateManualLottoTicket(manualTicketQuantity) + generateAutomaticLottoTicket(automaticTicketQuantity)
        outputView.showLottoTicket(lottoTickets)

        val (winnerTicket, bonusNumber) = WinnerTicket().generate(inputView.getWinnerNumber(), inputView.getBonusNumber())
        val winningStatistics =
            WinningCalculator().generateWinningStatistics(lottoTickets, winnerTicket, bonusNumber.value)
        outputView.showWinningStatistics(winningStatistics)
    }

    private fun generateManualLottoTicket(quantity: Int): List<LottoTicket> {
        outputView.showManualNumber()
        val result = List(quantity) { inputView.getManualNumber() }
        return ManualLottoTicketGenerator().generate(result)
    }

    private fun generateAutomaticLottoTicket(quantity: Int): List<LottoTicket> {
        return AutomaticLottoTicketGenerator().generate(quantity)
    }
}
