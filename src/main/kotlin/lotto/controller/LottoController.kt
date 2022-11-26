package lotto.controller

import lotto.domain.LottoVendingMachine
import lotto.domain.Rewards
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun run() {
        val purchaseAmount = InputView.getPurchaseAmount()
        ResultView.printNumberOfPurchases(purchaseAmount.getNumberOfLotto())

        val myLotto = LottoVendingMachine.buy(purchaseAmount)
        ResultView.printPurchasedLotto(myLotto)

        val winningNumbers = InputView.getWinningNumbers()
        val rewards = Rewards()
        myLotto.forEach {
            val numberOfMath = winningNumbers.getSumMatchingNumbers(it)
            rewards.add(numberOfMath)
        }

        ResultView.printRewardsStatistics(rewards)
        val reteOfReturn = rewards.calculateRateOfReturn(purchaseAmount)
        ResultView.printRateOfReturn(reteOfReturn)
    }
}
