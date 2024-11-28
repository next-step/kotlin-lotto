package lotto

import lotto.domain.Cashier
import lotto.domain.Lotto
import lotto.view.InputView

fun main() {
    val inputView = InputView()
    val inputAmount = inputView.inputPurchaseAmount()

    val numberOfLotto = Cashier(inputAmount).purchaseLotto()
    val lottos = Lotto.generate(numberOfLotto)
}
