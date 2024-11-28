package lotto

import lotto.domain.Cashier
import lotto.domain.Lotto
import lotto.stretagy.RandomLottoNumberListGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val randomNumberListGenerator = RandomLottoNumberListGenerator()
    val amount = InputView.purchaseAmount()

    val numberOfLotto = Cashier.purchaseLotto(amount)
    val lottos = List(numberOfLotto) { Lotto.createLotto(randomNumberListGenerator.generate()) }
    OutputView.printPurchaseResult(lottos)

    val winningNumbers = InputView.winningNumbers()
}
