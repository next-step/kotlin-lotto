package lotto

import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val price = inputView.inputPurchasePrice()

    val lottoMachine = LottoMachine(price)
    val lottoList = lottoMachine.publishLotto()
    resultView.printPurchaseCount(lottoMachine.purchaseCount)
    resultView.printPurchaseLotteNumbers(lottoList)

    val winningNumbersString = inputView.inputLastWeekNumbers()
    val winningLotto = WinningLotto(winningNumbersString)
    val bonusNumber = BonusNumber(LottoNumber(inputView.inputBonusNumber()), winningLotto.lotto)

    val winningResult = WinningResult(lottoList, winningLotto, bonusNumber)
    val winningStatistics = WinningStatistics(lottoMachine.price)

    resultView.printWinningStatisticsStart()
    for (rank in RANKING.values()) {
        if (rank != RANKING.MISS) {
            resultView.printWinningStatistics(rank, winningResult.getWinningResult(rank), rank.bonusMatched)
        }
    }
    resultView.printWinningStatisticsRate(winningStatistics.rateOfReturn(winningResult.getWinningPrice()))
}
