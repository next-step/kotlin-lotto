package lotto

import lotto.machine.AutoMachine
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(private val inputView: InputView, private val resultView: ResultView) {
    fun run() {
        val amount = inputView.getPurchaseAmount()
        val ticketCount = (amount / TICKET_COST).toInt()

        val manualTicketCount = inputView.getManualTicketCount()
        val winningLotto = inputView.getWinningNumbers()
        val order = Order(amount, manualTicketCount, listOf())

        val lottos = AutoMachine().generate(order)
        resultView.printLottos(lottos)

        val winningStatistics = WinningStatistics(lottos, winningLotto)

        resultView.printWinningStatistics(winningStatistics)
        resultView.printProfit(winningStatistics.calculateProfit(amount))
    }

    companion object {
        private const val TICKET_COST = 1000
        private const val DEFAULT = 0
    }
}
