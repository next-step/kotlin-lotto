package lotto.controller

import lotto.domain.LottoShop
import lotto.domain.PurchasedLottos
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

object LottoController {
    fun handle() {
        val purchaseAmount = LottoInputView.readPurchaseAmountInput()
        val lottos = LottoShop.purchaseLottos(purchaseAmount)
        val purchasedLottos = PurchasedLottos(lottos, purchaseAmount)
        LottoOutputView.printLottoOutput(purchasedLottos)

        val winningNumbers = LottoInputView.readWinningNumbersInput()
        val bonusNumber = LottoInputView.readBonusNumberInput()
        val winningStatistic = purchasedLottos.draw(winningNumbers, bonusNumber)
        LottoOutputView.printWinningStatistic(winningStatistic)
    }
}
