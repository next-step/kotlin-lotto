package specific.lotto

import specific.lotto.controller.LottoController
import specific.lotto.view.OutputView

fun main() {
    val controller = LottoController()
    val money = controller.makeMoney()
    val tickets = controller.makeTicket(money)
    val winningNumber = controller.makeWinningNumber()
    val winningResult = controller.makeWinningResult(tickets, winningNumber)
    OutputView.printReturnOnInvestment(money, winningResult)
}
