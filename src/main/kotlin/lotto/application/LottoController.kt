package lotto.application

import lotto.core.LottoMarket
import lotto.core.WinningLotto
import lotto.presentation.InputView
import lotto.presentation.ResultView

object LottoController {
    fun start() {
        val purchaseAmount = InputView.inputPurchaseAmount()
        val manualLottoCount = InputView.inputManualLottoCount()
        val manualLottoNumbers = InputView.inputManualLottoNumbers(manualLottoCount)

        val lottos = LottoMarket.purchase(purchaseAmount, manualLottoNumbers)
        ResultView.printLottos(lottos, manualLottoCount)

        val winningNumbers = InputView.inputWinningNumbers()
        val bonusNumber = InputView.inputBonusNumber()

        val lottoResult = lottos.countWinningRanks(WinningLotto(winningNumbers, bonusNumber))

        ResultView.printLottoResult(lottoResult)
        ResultView.printYieldRate(lottoResult, lottos)
    }
}
