package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoTicketBundle
import lotto.domain.StatisticalResultExtractor
import lotto.domain.strategy.LottoAutoGenerateStrategy
import lotto.domain.strategy.LottoManualGenerateStrategy
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val ticketAmount = InputView.getPurchaseAmount()
    val manualTicketCount = InputView.getManualTicketCount()
    val ticketCount = LottoMachine.calculateTicketCount(ticketAmount, manualTicketCount)
    InputView.printManualTicketNumber(ticketCount.manualTicketCount)
    val lottoTicketBundle = LottoTicketBundle(ticketCount, listOf(LottoAutoGenerateStrategy(), LottoManualGenerateStrategy()))
    InputView.printNumberOfPurchases(ticketCount)
    val winningBallResult = InputView.getWinningBalls()
    val lottoWinningResult = LottoMachine.process(lottoTicketBundle, winningBallResult)
    OutputView.printOutput(StatisticalResultExtractor(lottoWinningResult), lottoTicketBundle.lottoTickets.size)
}
