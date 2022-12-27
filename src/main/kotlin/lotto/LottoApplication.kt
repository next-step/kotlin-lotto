package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoStatistics
import lotto.domain.LottoTicket
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchasedAmount = InputView.purchaseAmountInput()

    val lottoMachine = LottoMachine()
    val ticketAmount = lottoMachine.getTicketAmount(purchasedAmount)

    ResultView.printTicketAmount(ticketAmount)

    val ticketBundle = listOf<LottoTicket>()
    repeat(ticketAmount) {
        ticketBundle.plus(
            element = lottoMachine.generate()
        )
    }

    val winningNumber = InputView.winningNumberInput()

    val statistics = LottoStatistics.calculate(ticketBundle, winningNumber)

    ResultView.printStatistics(statistics)
}
