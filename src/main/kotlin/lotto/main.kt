package lotto

import lotto.domain.LottoMachine
import lotto.ui.InputUI
import lotto.ui.OutputUI

fun main() {
    val amount = InputUI.receivePurchaseAmount()

    val lottoList = LottoMachine.buy(amount)

    OutputUI.drawPurchaseMessage(lottoList.size)
    OutputUI.drawLotto(lottoList)

    val winningNumbers = InputUI.receiveWinningNumbers()

    val lottoResult = lottoList.calculateLottoResult(winningNumbers)

    OutputUI.drawWinningResult(lottoResult)
    OutputUI.drawWinningRevenueRate(lottoResult.revenueRate)
}
