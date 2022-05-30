package lotto.domain

import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun run() {
        val ticketMachine = TicketMachine(NumberGenerator())
        val tickets = ticketMachine.buy(inputView.readAmount())
        outputView.printTickets(tickets)

        val winningNumbers = inputView.readWinningNumbers()
        val winningInfo = winningNumbers.compare(tickets)

        outputView.printStat(winningInfo)
        outputView.printRevenue(inputView.amount(), winningInfo.entries.sumOf { it.key.money * it.value })
    }
}
