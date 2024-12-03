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

    val cashier = Cashier(amount, randomNumberListGenerator)
    val lottos = cashier.purchaseLotto()

    OutputView.printPurchaseResult(lottos)

    val winningNumbers = InputView.winningNumbers()
    val winningLotto = Lotto.createLotto(winningNumbers)

    val statisticsList = Statistics.of(lottos, winningLotto)
    val earningRatio = Statistics.calculateEarningRatio(statisticsList, amount)
    OutputView.printLottoStatistics(statisticsList, earningRatio)
}
