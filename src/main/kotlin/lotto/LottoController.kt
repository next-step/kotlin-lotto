package lotto

fun main() {
    val controller = LottoController(InputView(), ResultView())
    val tickets = controller.purchase()
    controller.compareToWinningNumbers(tickets)
}

class LottoController(val inputView: InputView, val resultView: ResultView) {
    fun purchase() {
        val purchaseAmount = inputView.enterPurchaseAmount()
        val tickets = LottoShop().purchase(purchaseAmount)
        resultView.printTickets(tickets)
        return tickets
    }

    fun compareToWinningNumbers(tickets: Tickets) {
        val winningNumbers = inputView.enterWinningNumbers()
        val winningStatistics = WinningStatisticsCalculator().calculate(winningNumbers, tickets)
        resultView.printWinningStatistics(winningStatistics)
    }
}
