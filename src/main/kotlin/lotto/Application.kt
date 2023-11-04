package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    OutputView.printLottoCount(purchaseAmount / 1000)
}
