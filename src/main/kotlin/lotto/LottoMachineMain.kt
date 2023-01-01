package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.RANKING
import lotto.domain.StringNumbers
import lotto.domain.WinningLotto
import lotto.domain.WinningResult
import lotto.domain.WinningStatistics
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
    val bonusNumber = LottoNumber(inputView.inputBonusNumber())
    val winningLotto = WinningLotto(StringNumbers(winningNumbersString.split(",")), bonusNumber)

    val winningResult = WinningResult(lottoList, winningLotto)
    val winningStatistics = WinningStatistics(lottoMachine.price)

    resultView.printWinningStatisticsStart()
    for (rank in RANKING.values()) {
        if (rank != RANKING.MISS) {
            resultView.printWinningStatistics(rank, winningResult.getWinningResult(rank), rank.bonusMatched)
        }
    }
    resultView.printWinningStatisticsRate(winningStatistics.rateOfReturn(winningResult.getWinningPrice()))
}
