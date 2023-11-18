package specific.lotto.controller

import specific.lotto.domain.Money
import specific.lotto.domain.Number
import specific.lotto.domain.Rank
import specific.lotto.domain.Ticket
import specific.lotto.domain.TicketMachine
import specific.lotto.domain.WinningResult
import specific.lotto.domain.WinningSet
import specific.lotto.view.InputView
import specific.lotto.view.OutputView

class LottoController {
    fun inputMoney(): Money {
        val moneyInput = InputView.getMoney()
        require(!moneyInput.isNullOrBlank()) { "'moneyInput' cannot be null or blank" }
        val principal = moneyInput.toLongOrThrow { "'moneyInput' should be convertible to Int" }
        return Money(principal)
    }

    fun buyTicket(money: Money): List<Ticket> {
        val ticketMachine = TicketMachine()
        val tickets = ticketMachine.sellTickets(money)
        OutputView.printTickets(tickets)
        return tickets
    }

    fun inputWinningSet(): WinningSet {
        val winningNumberInput = InputView.getWinningNumber()
        require(!winningNumberInput.isNullOrBlank()) { "'winningNumberInput' cannot be null or blank" }
        val numberCombination = winningNumberInput
            .split(", ")
            .map { it.toIntOrThrow { "'lottoNumber' should be convertible to Int" } }
            .map { Number(it) }
            .toSet()
        return WinningSet(numberCombination)
    }

    fun makeWinningResult(tickets: List<Ticket>, winningSet: WinningSet): WinningResult {
        val ranks = tickets.map { Rank.decideRank(it, winningSet) }
        val winningResult = WinningResult(ranks)
        OutputView.printWinningResult(winningResult)
        return winningResult
    }

    fun receivePrize(money: Money, winningResult: WinningResult) {
        money.make(winningResult.totalPrize)
    }

    private fun String?.toIntOrThrow(lazyMessage: () -> Any): Int {
        require(!isNullOrBlank()) { lazyMessage }
        return this.toIntOrNull()
            ?: throw IllegalArgumentException(lazyMessage().toString())
    }

    private fun String?.toLongOrThrow(lazyMessage: () -> Any): Long {
        require(!isNullOrBlank()) { lazyMessage }
        return this.toLongOrNull()
            ?: throw IllegalArgumentException(lazyMessage().toString())
    }
}
