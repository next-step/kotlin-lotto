package lotto

import lotto.domain.LottoNumbers
import lotto.domain.LottoSeller
import lotto.domain.OrderSheet
import lotto.ui.InputUI
import lotto.ui.OutputUI

object LottoGame {

    fun run() {
        val money = InputUI.receivePurchaseAmount()
        val manualPurchaseCount = InputUI.receiveManualPurchaseCount()

        val order = LottoSeller.order(money, manualPurchaseCount)

        if (order.isValid()) {
            proceed(manualPurchaseCount, order)
        } else {
            OutputUI.drawErrorMessage("구매 금액보다 많은 양은 구매할 수 없습니다.")
        }
    }

    private fun proceed(manualPurchaseCount: Int, order: OrderSheet) {
        val manualLotto = receiveManual(manualPurchaseCount)
        val lottoList = LottoSeller.take(order, manualLotto)

        OutputUI.drawPurchaseMessage(order)
        OutputUI.drawLotto(lottoList)

        val winningNumbers = InputUI.receiveWinningNumbers()
        val bonusNumber = InputUI.receiveBonusNumber()

        val lottoResult = lottoList.match(winningNumbers, bonusNumber)

        OutputUI.drawWinningResult(lottoResult)
        OutputUI.drawWinningRevenueRate(lottoResult.revenueRate)
    }

    private fun receiveManual(manualPurchaseCount: Int): List<LottoNumbers> {
        if (manualPurchaseCount <= 0) return emptyList()

        OutputUI.drawManualInputRequest()
        return (0 until manualPurchaseCount).map {
            InputUI.receiveManualNumbers()
        }
    }
}

fun main() {
    LottoGame.run()
}
