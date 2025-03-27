package lotto

import lotto.view.InputView

fun main() {
    val purchaseAmount = InputView.requestPurchaseAmount()
    println(purchaseAmount)
}
