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
        val winningStatistics =
            drawWinnerNumber(purchaseLottoTicket(ticketQuantity), WinnerNumber(inputView.getWinnerNumber()))
        resultView.showWinningStatistics(winningStatistics)
    }

    fun purchaseLottoTicket(quantity: Int): List<LottoTicket> {
        return (0 until quantity).map {
            LottoTicket()
        }
    }

    private fun drawWinnerNumber(lottoTickets: List<LottoTicket>, winnerNumber: WinnerNumber): WinningStatistics {
        return WinningCalculator(lottoTickets, winnerNumber).winningStatistics
    }
}
