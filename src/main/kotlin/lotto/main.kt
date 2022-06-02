package lotto

import lotto.domain.LottoSeller
import lotto.ui.InputUI
import lotto.ui.OutputUI

fun main() {
    val money = InputUI.receivePurchaseAmount()

    val lottoList = LottoSeller.buy(money)

    OutputUI.drawPurchaseMessage(lottoList.size)
    OutputUI.drawLotto(lottoList)

    val winningNumbers = InputUI.receiveWinningNumbers()

    val lottoResult = lottoList.match(winningNumbers)

    OutputUI.drawWinningResult(lottoResult)
    OutputUI.drawWinningRevenueRate(lottoResult.revenueRate)
}
