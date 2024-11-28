package lotto

import lotto.domain.Cashier
import lotto.domain.Lotto
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val inputAmount = inputView.inputPurchaseAmount()

    val numberOfLotto = Cashier(inputAmount).purchaseLotto()
    val lottos = Lotto.generate(numberOfLotto)
    outputView.printPurchaseResult(lottos)
}
