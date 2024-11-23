package lotto

import lotto.domain.LottoPurchaseAmount
import lotto.domain.User
import lotto.view.InputView

fun main() {
    val lottoPurchaseAmount = LottoPurchaseAmount(InputView.inputPurchaseAmount())
    val user = User(lottoPurchaseAmount)
}
