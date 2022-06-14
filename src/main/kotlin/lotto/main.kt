package lotto

import lotto.domain.LottoSeller
import lotto.ui.InputUI
import lotto.ui.OutputUI

fun main() {
    val money = InputUI.receivePurchaseAmount()
    val manualPurchaseCount = InputUI.receiveManualPurchaseCount()

    val order = LottoSeller.order(money, manualPurchaseCount)

    if (order.isValid()) {
        OutputUI.drawManualInputRequest()
        val manualLotto = (0 until manualPurchaseCount).map {
            InputUI.receiveManualNumbers()
        }

        val lottoList = LottoSeller.take(order, manualLotto)

        OutputUI.drawPurchaseMessage(order)
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
