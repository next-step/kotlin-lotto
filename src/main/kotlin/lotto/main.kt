package lotto

import lotto.domain.LottoSeller
import lotto.ui.InputUI
import lotto.ui.OutputUI

fun main() {
    val money = InputUI.receivePurchaseAmount()
    val manualPurchaseCount = InputUI.receiveManualPurchaseCount()

    if (LottoSeller.canPurchase(money, manualPurchaseCount)) {
        OutputUI.drawManualInputRequest()
        val manualLotto = (0 until manualPurchaseCount).map {
            InputUI.receiveManualNumbers()
        }

        val lottoList = LottoSeller.buy(money, manualLotto)

        OutputUI.drawPurchaseMessage(lottoList.size)
        OutputUI.drawLotto(lottoList)

        val winningNumbers = InputUI.receiveWinningNumbers()
        val bonusNumber = InputUI.receiveBonusNumber()

        val lottoResult = lottoList.match(winningNumbers, bonusNumber)

        OutputUI.drawWinningResult(lottoResult)
        OutputUI.drawWinningRevenueRate(lottoResult.revenueRate)
    } else {
        OutputUI.drawErrorMessage("구매 금액보다 많은 양은 구매할 수 없습니다.")
    }
}
