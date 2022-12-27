package lotto

import lotto.domain.LottoTicketBundle
import lotto.domain.StatisticalResultExtractor
import lotto.domain.WinningNumberExtractor
import lotto.domain.WinningBalls
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val ticketAmount = InputView.getPurchaseAmount()
    val lottoTicketBundle = LottoTicketBundle(ticketAmount)
    InputView.getNumberOfPurchases(lottoTicketBundle.lottoTickets.size)
    val winningBalls = InputView.getWinningBalls()
    val lottoWinning = WinningNumberExtractor.process(
        lottoTicketBundle, WinningBalls(winningBalls.first, winningBalls.second)
    )
    OutputView.printOutput(StatisticalResultExtractor(lottoWinning), lottoTicketBundle.lottoTickets.size)
}
