package lotto.controller

import lotto.domain.PurchasedLottos
import lotto.domain.RandomLottoNumberGenerator
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

object LottoController {
    fun handle() {
        val purchaseAmount = LottoInputView.readPurchaseAmountInput()
        val manualLottoCount = LottoInputView.readManualLottoCountInput()
        val manualLottoNumbers = LottoInputView.readManualLottoNumbersInput(manualLottoCount)
        val purchasedLottos = PurchasedLottos(purchaseAmount, manualLottoNumbers, RandomLottoNumberGenerator)
        LottoOutputView.printLottoOutput(purchasedLottos, manualLottoCount)

        val winningNumbers = LottoInputView.readWinningNumbersInput()
        val bonusNumber = LottoInputView.readBonusNumberInput()
        val winningStatistic = purchasedLottos.draw(winningNumbers, bonusNumber)
        LottoOutputView.printWinningStatistic(winningStatistic)
    }
}
