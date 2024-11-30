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
        val bonusNumber = InputView.inputBonusNumber()

        val lottoResult = LottoWinningStatisticsService.start(lottos, winningNumbers, bonusNumber)

        ResultView.printLottoResult(lottoResult)
        ResultView.printYieldRate(lottoResult, lottos)
    }
}
