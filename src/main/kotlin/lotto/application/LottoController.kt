package lotto.application

import lotto.core.LottoMarket
import lotto.presentation.InputView
import lotto.presentation.ResultView

object LottoController {
    fun start() {
        val purchaseAmount = InputView.inputPurchaseAmount()
        val lottos = LottoMarket.purchase(purchaseAmount)
        ResultView.printLottos(lottos)

        val winningNumbers = InputView.inputWinningNumbers()
        val winningStatistics = LottoWinningStatisticsService.start(lottos, winningNumbers)

        ResultView.printWinningStatistics(winningStatistics)
    }
}
