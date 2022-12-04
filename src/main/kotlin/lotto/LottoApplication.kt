package lotto

import lotto.domain.LottoTicketBundle
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val tickets = InputView.getNumberOfPurchases()
    val lottoTicketBundle = LottoTicketBundle(tickets).lottoTickets
    val winningNumber = InputView.getWinningNumber()
    val lottoWinning = WinningNumberExtractor().process(lottoTicketBundle, winningNumber)
    OutputView.printOutput(StatisticalResultExtractor(lottoWinning), tickets)
}
