package lotto

import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val inputView = InputView()
    inputView.inputPurchasingAmount()
    inputView.showPurchaseResult()

    val resultView = ResultView()
    resultView.inputWinningNumbers()
    resultView.checkWinningLottoList(lottoList = inputView.lottoList)
    resultView.showResult(amount = inputView.amount)
}
