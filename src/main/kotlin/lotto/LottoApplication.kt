package lotto

import lotto.domain.LottoTicketBundle
import lotto.domain.StatisticalResultExtractor
import lotto.domain.WinningNumberExtractor
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val ticketAmount = InputView.getPurchaseAmount()
    val lottoTicketBundle = LottoTicketBundle(ticketAmount)
    InputView.getNumberOfPurchases(lottoTicketBundle.lottoTickets.size)
    val winningBallResult = InputView.getWinningBalls()
    val lottoWinningResult = WinningNumberExtractor.process(lottoTicketBundle, winningBallResult)
    OutputView.printOutput(StatisticalResultExtractor(lottoWinningResult), lottoTicketBundle.lottoTickets.size)
}
