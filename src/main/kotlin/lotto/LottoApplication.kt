package lotto

import lotto.domain.LottoTicketBundle
import lotto.domain.StatisticalResultExtractor
import lotto.domain.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val ticketAmount = InputView.getPurchaseAmount()
    val lottoTicketBundle = LottoTicketBundle(ticketAmount).lottoTickets
    InputView.getNumberOfPurchases(lottoTicketBundle.size)
    val winningNumber = InputView.getWinningNumber()
    val lottoWinning = WinningNumberExtractor.process(
        lottoTicketBundle, WinningNumbers(winningNumber.first, winningNumber.second)
    )
    OutputView.printOutput(StatisticalResultExtractor(lottoWinning), lottoTicketBundle.size)
}
