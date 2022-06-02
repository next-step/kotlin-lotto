package lotto.controller

import lotto.domain.LottoNumber
import lotto.domain.TicketMachine
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun run() {
        val ticketMachine = TicketMachine(LottoNumber.randomGenerator())

        val amount = inputView.readAmount()
        val manualTickets = inputView.readManual()

        val tickets = ticketMachine.buy(amount, manualTickets)
        outputView.printTickets(tickets, manualTickets.size)

        val winningNumbers = inputView.readWinningNumbers()
        val winningInfo = winningNumbers.compare(tickets)

        outputView.printStat(winningInfo)
        outputView.printRevenue(inputView.amount(), winningInfo.entries.sumOf { it.key.money * it.value })
    }
}
