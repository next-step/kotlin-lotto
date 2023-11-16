package specific.lotto.controller

import specific.lotto.domain.Money
import specific.lotto.domain.NumberCombination
import specific.lotto.domain.Store
import specific.lotto.domain.Ticket
import specific.lotto.domain.WinningNumber
import specific.lotto.domain.WinningResult
import specific.lotto.view.InputView
import specific.lotto.view.OutputView
import toIntOrThrow

class LottoController(
    val store: Store = Store()
) {
    fun makeMoney(): Money {
        val moneyInput = InputView.getMoney()
        require(!moneyInput.isNullOrBlank()) { "'moneyInput' cannot be null or blank" }
        val principal = moneyInput.toIntOrThrow { "'moneyInput' should be convertible to Int" }
        return Money(principal)
    }

    fun makeTicket(money: Money): List<Ticket> {
        val tickets = store.buyTickets(money)
        OutputView.printTickets(tickets)
        return tickets
    }

    fun makeWinningNumber(): WinningNumber {
        val winningNumberInput = InputView.getWinningNumber()
        require(!winningNumberInput.isNullOrBlank()) { "'winningNumberInput' cannot be null or blank" }
        val numberCombination = winningNumberInput
            .split(", ")
            .map { it.toIntOrThrow { "'lottoNumber' should be convertible to Int" } }
            .let { NumberCombination(it) }
        return WinningNumber(numberCombination)
    }

    fun makeWinningResult(tickets: List<Ticket>, winningNumber: WinningNumber): WinningResult {
        val winningResult = WinningResult(tickets, winningNumber)
        OutputView.printWinningResult(winningResult)
        return winningResult
    }
}
