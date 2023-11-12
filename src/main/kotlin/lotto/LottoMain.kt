package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView
    val resultView = ResultView

    val lottoNumbers = inputView.inputPurchaseAmount()

    val winningNumbers = inputView.inputWinningNumbers()
    val winningResult = LottoMachine.checkWinningNumbers(lottoNumbers, winningNumbers)
    val totalPrize = LottoMachine.calculateTotalPrize(winningResult)

    resultView.printWinningStatistics(winningResult)
    resultView.printTotalProfitRate(totalPrize, lottoNumbers.size)
}
