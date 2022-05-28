package lotto

import lotto.domain.NumberGenerator
import lotto.domain.TicketMachine
import lotto.view.InputView
import lotto.view.OutputView

class LottoSimulator(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun run() {
        val ticketMachine = TicketMachine(NumberGenerator())
        val tickets = ticketMachine.buy(inputView.amount())
        outputView.printTickets(tickets)
        val winningNumbers = inputView.winningNumbers()
        println(winningNumbers)
    }
}

fun main() {
    val lottoSimulator = LottoSimulator(InputView(), OutputView())
    lottoSimulator.run()
}
