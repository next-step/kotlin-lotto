package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoTicketBundle
import lotto.domain.StatisticalResultExtractor
import lotto.domain.WinningNumberExtractor
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val ticketAmount = InputView.getPurchaseAmount()
    val manualTicketCount = InputView.getManualTicketCount()
    val ticketCount = LottoMachine.calculateTicketCount(ticketAmount, manualTicketCount)

    val lottoTicketBundle = LottoTicketBundle(ticketCount)
    InputView.getNumberOfPurchases(ticketCount)

    val winningBallResult = InputView.getWinningBalls()
    val lottoWinningResult = WinningNumberExtractor.process(lottoTicketBundle, winningBallResult)
    OutputView.printOutput(StatisticalResultExtractor(lottoWinningResult), lottoTicketBundle.lottoTickets.size)
}
