package lotto

import lotto.domain.LottoComparator
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

    var ticketBundle = mutableListOf<LottoTicket>()
    repeat(ticketAmount) {
        ticketBundle.add(
            element = lottoMachine.generate()
        )
    }

    val winningNumber = InputView.winningNumberInput()

    val rank = LottoComparator.compare(ticketBundle, winningNumber)
    val rate = LottoStatistics.getRateOfReturn(rank, purchasedAmount)

    ResultView.printRateOfReturn(rate)
}
