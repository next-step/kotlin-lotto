package lotto.ui

import lotto.LottoMachine
import lotto.WinningMachine
import lotto.WinningStatistics

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val price = inputView.inputPurchasePrice()

    val lottoMachine = LottoMachine(price)
    val lottoList = lottoMachine.publishLotto()
    resultView.printPurchaseCount(lottoMachine.purchaseCount)
    resultView.printPurchaseLotteNumbers(lottoList)

    val winningNumbersString = inputView.inputLastWeekNumbers()
    val winningMachine = WinningMachine(winningNumbersString)

    val winningStatistics = WinningStatistics(lottoList, winningMachine.winningNumbers)
    val resultStatistics = winningStatistics.winningCheck()

    resultView.printWinningStatisticsStart()
    for (place in WinningStatistics.RANKING.values()) {
        resultView.printWinningStatistics(place, resultStatistics[place] ?: 0)
    }
    resultView.printWinningStatisticsRate(winningStatistics.rateOfReturn())
}
