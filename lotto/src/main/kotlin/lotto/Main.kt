package lotto

import lotto.domain.LottoPurchaseAmount
import lotto.view.InputView

fun main() {
    val lottoPurchaseAmount = LottoPurchaseAmount(InputView.inputPurchaseAmount())
}
