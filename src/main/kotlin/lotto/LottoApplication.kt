package lotto

import lotto.domain.Cashier
import lotto.domain.Lotto
import lotto.stretagy.LottoNumberListGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoNumberListGenerator = LottoNumberListGenerator()
    val amount = InputView.purchaseAmount()

    val numberOfLotto = Cashier.purchaseLotto(amount)
    val lottos = Lotto.generate(lottoNumberListGenerator, numberOfLotto)
    OutputView.printPurchaseResult(lottos)

    val winningNumbers = InputView.winningNumbers()
}
