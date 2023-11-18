package specific.lotto

import specific.lotto.controller.LottoController
import specific.lotto.view.OutputView

fun main() {
    val controller = LottoController()
    val money = controller.inputMoney()
    val tickets = controller.buyTicket(money)
    val winningNumber = controller.inputWinningSet()
    val winningResult = controller.makeWinningResult(tickets, winningNumber)
    controller.receivePrize(money, winningResult)
    OutputView.printReturnOnInvestment(money)
}
