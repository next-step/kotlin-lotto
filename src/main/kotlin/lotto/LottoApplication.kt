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

    val userLottos = Cashier.purchaseLotto(amount, randomNumberListGenerator)
    OutputView.printPurchaseResult(userLottos)

    val winningNumbers = InputView.winningNumbers()
    val winningLotto = Lotto.createLotto(winningNumbers)

    val statisticsList = Statistics.of(userLottos, winningLotto)
    val earningRatio = Statistics.calculateEarningRatio(statisticsList, amount)
    OutputView.printLottoStatistics(statisticsList, earningRatio)
}
