package lotto.controller

import lotto.domain.LottoVendingMachine
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun run() {
        val purchaseAmount = InputView.getPurchaseAmount()
        val purchaseCount = purchaseAmount.getNumberOfLotto()

        val manualNumberOfLotto = InputView.getManualNumberOfLotto(purchaseAmount)
        val inputManualNumbers = InputView.getManualLottos(manualNumberOfLotto)

        val userLottos = LottoVendingMachine.buyLottos(purchaseAmount, inputManualNumbers)
        ResultView.printPurchaseStatus(manualNumberOfLotto, purchaseCount - manualNumberOfLotto)
        ResultView.printPurchasedLotto(userLottos)

        val inputWinningNumbers = InputView.getWinningNumbers()
        val inputBonusNumber = InputView.getBonusNumber()
        val winningLottoNumbers = LottoVendingMachine.makeWinningLotto(inputWinningNumbers, inputBonusNumber)
        val winningStatistics = winningLottoNumbers.makeStatistics(userLottos)
        ResultView.printRewardsStatistics(winningStatistics)

        val rateOfReturn = winningStatistics.calculateRateOfReturn(purchaseAmount)
        ResultView.printRateOfReturn(rateOfReturn)
    }
}
