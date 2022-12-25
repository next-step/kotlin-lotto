package lotto.controller

import lotto.model.AutomaticLottoTicketGenerator
import lotto.model.LottoNumber
import lotto.model.LottoTicket
import lotto.model.ManualLottoTicketGenerator
import lotto.model.TicketQuantity
import lotto.model.WinningCalculator
import lotto.model.WinningStatistics
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun start() {
        val automaticTicketQuantity = TicketQuantity(inputView.getAmountOfMoney()).quantity
        val manualTicketQuantity = inputView.getManualQuantity().toInt()
        val manualLottoTickets =
            ManualLottoTicketGenerator(purchaseManualLottoTicket(manualTicketQuantity)).tickets
        outputView.showQuantity(manualTicketQuantity, automaticTicketQuantity)
        val automaticLottoTickets = purchaseAutomaticLottoTicket(automaticTicketQuantity)
        val lottoTickets = joinTickets(manualLottoTickets, automaticLottoTickets)
        outputView.showLottoTicket(lottoTickets)
        val winnerTicket = LottoTicket(inputView.getWinnerNumber())
        val bonusNumber = LottoNumber(inputView.getBonusNumber())
        val winningStatistics = drawWinnerNumber(lottoTickets, winnerTicket, bonusNumber)
        outputView.showWinningStatistics(winningStatistics)
    }

    private fun purchaseManualLottoTicket(quantity: Int): List<String> {
        var result = mutableListOf<String>()
        outputView.showManualNumber()
        for (i in 1..quantity) {
            result.add(inputView.getManualNumber())
        }
        return result
    }

    fun purchaseAutomaticLottoTicket(quantity: Int): List<LottoTicket> {
        return AutomaticLottoTicketGenerator(quantity).tickets
    }

    private fun joinTickets(
        manualLottoTickets: List<LottoTicket>,
        automaticLottoTickets: List<LottoTicket>
    ): List<LottoTicket> {
        val lottoTickets = mutableListOf<LottoTicket>()
        lottoTickets.addAll(manualLottoTickets)
        lottoTickets.addAll(automaticLottoTickets)
        return lottoTickets
    }

    private fun drawWinnerNumber(
        automaticLottoTickets: List<LottoTicket>,
        winnerTicket: LottoTicket,
        bonusNumber: LottoNumber
    ): WinningStatistics {
        return WinningCalculator(automaticLottoTickets, winnerTicket, bonusNumber.value).winningStatistics
    }
}
