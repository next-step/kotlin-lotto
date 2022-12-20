package lotto.controller

import lotto.model.LottoTicket
import lotto.model.TicketQuantity
import lotto.model.WinnerNumber
import lotto.model.WinningCalculator
import lotto.model.WinningStatistics
import lotto.view.InputView
import lotto.view.ResultView

class LottoGame {
    private val resultView = ResultView()
    private val inputView = InputView()

    fun start() {
        val ticketQuantity = TicketQuantity(InputView().getAmountOfMoney()).quantity
        resultView.showQuantity(ticketQuantity)
        val tickets = purchaseLottoTicket(ticketQuantity)
        resultView.showLottoTicket(tickets)
        val winnerNumber = WinnerNumber(inputView.getWinnerNumber())
        val bonusNumber = inputView.getBonusNumber()
        val winningStatistics = drawWinnerNumber(tickets, winnerNumber, bonusNumber)
        resultView.showWinningStatistics(winningStatistics)
    }

    fun purchaseLottoTicket(quantity: Int): List<LottoTicket> {
        return (0 until quantity).map {
            LottoTicket()
        }
    }

    private fun drawWinnerNumber(lottoTickets: List<LottoTicket>, winnerNumber: WinnerNumber, bonusNumber: Int): WinningStatistics {
        return WinningCalculator(lottoTickets, winnerNumber, bonusNumber).winningStatistics
    }
}
