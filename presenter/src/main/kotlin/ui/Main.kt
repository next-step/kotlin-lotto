package ui

import ui.input.InputView
import ui.result.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val purchaseAmount = inputView.enterPurchaseAmount()
    val generatedLotteries = resultView.displayPurchasedLottoLotteries(purchaseAmount)
    println()

    val winningNumbers = inputView.enterLastWeekWinningNumbers()
    resultView.displayWinningStatistics(generatedLotteries, winningNumbers)
}
