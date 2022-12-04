package lotto

import lotto.domain.LottoTicketBundle
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val ticketCount = InputView.getNumberOfPurchases()
    val lottoTicketBundle = LottoTicketBundle(ticketCount).lottoTickets
    val winningNumber = InputView.getWinningNumber()
    val lottoWinning = WinningNumberExtractor().process(lottoTicketBundle, winningNumber)
    OutputView.printOutput(StatisticalResultExtractor(lottoWinning), ticketCount)
}
