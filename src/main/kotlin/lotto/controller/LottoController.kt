package lotto.controller

import lotto.domain.LottoVendingMachine
import lotto.domain.WinningStatistics
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun run() {
        val purchaseAmount = InputView.getPurchaseAmount()
        val purchaseCount = purchaseAmount.getNumberOfLotto()
        ResultView.printNumberOfPurchases(purchaseCount)

        val myLotteries = LottoVendingMachine.buy(purchaseCount)
        ResultView.printPurchasedLotto(myLotteries)

        val winningLottoNumbers = InputView.getWinningNumbers()
        val numberOfMatches = winningLottoNumbers.getAllNumberOfMatches(myLotteries)
        val winningStatistics = WinningStatistics().add(numberOfMatches)
        ResultView.printRewardsStatistics(winningStatistics)

        val rateOfReturn = winningStatistics.calculateRateOfReturn(purchaseAmount)
        ResultView.printRateOfReturn(rateOfReturn)
    }
}
