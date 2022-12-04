package lotto.controller

import lotto.domain.LottoVendingMachine
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun run() {
        val purchaseAmount = InputView.getPurchaseAmount()
        val purchaseCount = purchaseAmount.getNumberOfLotto()

        val manualNumberOfLotto = InputView.getManualNumberOfLotto(purchaseAmount)
        val manualUserLottos = InputView.getManualLottos(manualNumberOfLotto)
        val randomNumberOfLotto = purchaseCount - manualNumberOfLotto

        val randomUserLottos = LottoVendingMachine.buyRandomLottos(randomNumberOfLotto)
        val userLottos = manualUserLottos.addAll(randomUserLottos)
        ResultView.printPurchaseStatus(manualNumberOfLotto, randomNumberOfLotto)
        ResultView.printPurchasedLotto(userLottos)

        val winningLottoNumbers = InputView.getWinningLottoNumbers()
        val winningStatistics = winningLottoNumbers.makeStatistics(userLottos)
        ResultView.printRewardsStatistics(winningStatistics)

        val rateOfReturn = winningStatistics.calculateRateOfReturn(purchaseAmount)
        ResultView.printRateOfReturn(rateOfReturn)
    }
}
