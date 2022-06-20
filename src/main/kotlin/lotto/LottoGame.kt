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

        when (val order = LottoSeller.order(money, manualPurchaseCount)) {
            is OrderSheet.Valid -> proceed(order)
            else -> OutputUI.drawErrorMessage("구매 금액보다 많은 양은 구매할 수 없습니다.")
        }
    }

    private fun proceed(order: OrderSheet.Valid) {
        val lottoList = LottoSeller.take(order, ::receiveManual)

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
        return List(manualPurchaseCount) { InputUI.receiveManualNumbers() }
    }
}

fun main() {
    LottoGame.run()
}
