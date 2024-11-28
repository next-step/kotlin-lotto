package lotto

import lotto.domain.Cashier
import lotto.domain.Lotto
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val amount = InputView.purchaseAmount()

    val numberOfLotto = Cashier(amount).purchaseLotto()
    val lottos = Lotto.generate(numberOfLotto)
    OutputView.printPurchaseResult(lottos)

    val winningNumbers = InputView.winningNumbers()
}
