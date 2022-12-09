package lotto.ui

import lotto.LottoMachine
import lotto.RANKING
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
    val winningResult = winningMachine.winningResult(lottoList)

    val winningStatistics = WinningStatistics(lottoMachine.price, winningResult)

    resultView.printWinningStatisticsStart()
    for (rank in RANKING.values()) {
        resultView.printWinningStatistics(rank, winningResult[rank] ?: 0)
    }
    resultView.printWinningStatisticsRate(winningStatistics.rateOfReturn())
}
