package lotto.controller

import lotto.model.LottoNumber
import lotto.model.LottoTicket
import lotto.model.RandomLottoTicketGenerator
import lotto.model.TicketQuantity
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
        val lottoTicket = LottoTicket(inputView.getWinnerNumber())
        val bonusNumber = LottoNumber(inputView.getBonusNumber())
        val winningStatistics = drawWinnerNumber(tickets, lottoTicket, bonusNumber)
        resultView.showWinningStatistics(winningStatistics)
    }

    fun purchaseLottoTicket(quantity: Int): List<RandomLottoTicketGenerator> {
        return List(quantity) { RandomLottoTicketGenerator() }
    }

    private fun drawWinnerNumber(randomLottoTickets: List<RandomLottoTicketGenerator>, lottoTicket: LottoTicket, bonusNumber: LottoNumber): WinningStatistics {
        return WinningCalculator(randomLottoTickets, lottoTicket, bonusNumber.value).winningStatistics
    }
}
