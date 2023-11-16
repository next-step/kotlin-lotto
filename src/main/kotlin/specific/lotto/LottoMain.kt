package specific.lotto

import specific.lotto.domain.Money
import specific.lotto.domain.Store
import specific.lotto.domain.WinningNumber
import specific.lotto.domain.WinningResult
import specific.lotto.view.InputView
import specific.lotto.view.OutputView

fun main() {
    val store = Store()
    val money = Money(InputView.getMoney())
    val tickets = store.buyTickets(money)
    OutputView.printTickets(tickets);
    val winningNumber = WinningNumber(InputView.getWinningNumber())
    val winningResult = WinningResult(tickets, winningNumber)
    OutputView.printWinningResult(winningResult)
    OutputView.printReturnOnInvestment(money, winningResult)
}
