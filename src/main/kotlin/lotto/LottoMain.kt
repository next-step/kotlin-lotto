package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView
    val resultView = ResultView

    val lottoMachine = inputView.inputPurchaseAmount()
    val winningNumbers = inputView.inputWinningNumbers()
    val winningResult = lottoMachine.checkWinningNumbers(winningNumbers)
    val totalPrize = lottoMachine.calculateTotalPrize(winningResult)

    resultView.printWinningStatistics(winningResult)
    resultView.printTotalProfitRate(totalPrize, lottoMachine)
}
