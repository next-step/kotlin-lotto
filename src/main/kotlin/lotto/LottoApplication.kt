package lotto

import lotto.domain.Cashier
import lotto.domain.Lotto
import lotto.domain.Statistics
import lotto.stretagy.RandomLottoNumberListGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val randomNumberListGenerator = RandomLottoNumberListGenerator()
    val amount = InputView.purchaseAmount()

    val numberOfLotto = Cashier.purchaseLotto(amount)
    val userLottos = List(numberOfLotto) { Lotto.createLotto(randomNumberListGenerator.generate()) }
    OutputView.printPurchaseResult(userLottos)

    val winningNumbers = InputView.winningNumbers()
    val winningLotto = Lotto.createLotto(winningNumbers)

    val lottoStatistics = Statistics.of(userLottos, winningLotto)
    OutputView.printLottoStatistics(lottoStatistics, amount)
}
