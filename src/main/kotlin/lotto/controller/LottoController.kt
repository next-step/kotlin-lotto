package lotto.controller

import lotto.domain.LottoShop
import lotto.domain.Tickets
import lotto.domain.WinningStatisticsCalculator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val controller = LottoController(InputView(), ResultView())
    val tickets = controller.purchase()
    controller.compareToWinningNumbers(tickets)
}

class LottoController(private val inputView: InputView, private val resultView: ResultView) {
    fun purchase(): Tickets {
        val purchaseAmount = inputView.enterPurchaseAmount()
        val manualTickets = inputView.enterManualTickets()
        val tickets = LottoShop().purchase(purchaseAmount, manualTickets)
        resultView.printTickets(tickets, manualTickets.size, tickets.size - manualTickets.size)
        return tickets
    }

    fun compareToWinningNumbers(tickets: Tickets) {
        val winningNumbers = WinningNumbers(inputView.enterWinningNumbers(), inputView.enterBonusNumber())
        val (winningStatistics, rate) = WinningStatisticsCalculator().calculate(winningNumbers, tickets)
        resultView.printWinningStatistics(winningStatistics, rate)
    }
}
