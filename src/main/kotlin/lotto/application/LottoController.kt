package lotto.application

import lotto.presentation.InputView
import lotto.presentation.ResultView

object LottoController {
    fun start() {
        val purchaseAmount = InputView.inputPurchaseAmount()
        val lottos = LottoMarketService.start(purchaseAmount)
        ResultView.printLottos(lottos)

        val winningNumber = InputView.inputWinningNumbers()
        val winningStatistics = LottoWinningStatisticsService.start(lottos, winningNumber)

        ResultView.printWinningStatistics(winningStatistics)
    }
}
