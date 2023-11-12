package lotto.controller

import lotto.domain.PurchasedLottos
import lotto.domain.RandomLottoNumberGenerator
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

object LottoController {
    fun handle() {
        val purchaseAmount = LottoInputView.readPurchaseAmountInput()
        val purchasedLottos = PurchasedLottos(purchaseAmount, RandomLottoNumberGenerator)
        LottoOutputView.printLottoOutput(purchasedLottos)

        val winningNumbers = LottoInputView.readWinningNumbersInput()
        val bonusNumber = LottoInputView.readBonusNumberInput()
        val winningStatistic = purchasedLottos.draw(winningNumbers, bonusNumber)
        LottoOutputView.printWinningStatistic(winningStatistic)
    }
}
