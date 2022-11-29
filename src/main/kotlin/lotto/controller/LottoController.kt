package lotto.controller

import lotto.domain.LottoVendingMachine
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun run() {
        val purchaseAmount = InputView.getPurchaseAmount()
        val purchaseCount = purchaseAmount.getNumberOfLotto()
        ResultView.printNumberOfPurchases(purchaseCount)

        val myLotteries = LottoVendingMachine.buy(purchaseCount)
        ResultView.printPurchasedLotto(myLotteries)

        val winningLottoNumbers = InputView.getWinningLottoNumbers()
        val winningStatistics = winningLottoNumbers.makeStatistics(myLotteries)
        ResultView.printRewardsStatistics(winningStatistics)

        val rateOfReturn = winningStatistics.calculateRateOfReturn(purchaseAmount)
        ResultView.printRateOfReturn(rateOfReturn)
    }
}
