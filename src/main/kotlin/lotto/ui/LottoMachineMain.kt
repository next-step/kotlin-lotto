package lotto.ui

import lotto.*

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val price = inputView.inputPurchasePrice()

    val lottoMachine = LottoMachine(price)
    val lottoList = lottoMachine.publishLotto()
    resultView.printPurchaseCount(lottoMachine.purchaseCount)
    resultView.printPurchaseLotteNumbers(lottoList)

    val winningNumbersString = inputView.inputLastWeekNumbers()
    val bonusNumber = LottoNumber(inputView.inputLastWeekNumbers())
    val winningLotto = WinningLotto(winningNumbersString, bonusNumber)

    val winningResult = WinningResult(lottoList, winningLotto)
    val winningStatistics = WinningStatistics(lottoMachine.price)

    resultView.printWinningStatisticsStart()
    for (rank in RANKING.values()) {
        if (rank != RANKING.MISS) {
            resultView.printWinningStatistics(rank, winningResult.getWinningResult(rank))
        }
    }
    resultView.printWinningStatisticsRate(winningStatistics.rateOfReturn(winningResult.getWinningPrice()))
}
