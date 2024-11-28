package lotto.application

import lotto.core.Lotto
import lotto.core.LottoMarket
import lotto.core.WinningNumbers
import lotto.presentation.InputView
import lotto.presentation.ResultView

object LottoController {
    fun start() {
        val purchaseAmount = InputView.inputPurchaseAmount()
        val lottos = LottoMarket.purchase(purchaseAmount)
        ResultView.printLottos(lottos)

        val winningNumbers = InputView.inputWinningNumbers()
        val bonusNumber = InputView.inputBonusNumber()

        val winningStatistics = LottoWinningStatisticsService.start(lottos, winningNumbers, bonusNumber)

        ResultView.printWinningStatistics(winningStatistics)
    }
}
