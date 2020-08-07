package lotto

import lotto.domain.Buyer
import lotto.domain.LottoStatistics
import lotto.domain.Lottos
import lotto.view.InputView
import lotto.view.ResultView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val price = InputView.purchasePrice()

        val purchaseCount = Buyer(price).purchaseCount
        val lottos = Lottos.of(purchaseCount)
        ResultView.showPurchasedLottos(purchaseCount, lottos.lottos)

        val winningNumbers = InputView.lastWinningNumbers()
        val bonusNumber = InputView.bonusNumber()
        lottos.matchWinningCount(winningNumbers, bonusNumber)

        ResultView.showWinningResult(lottos)

        val calculateRatio = LottoStatistics.calculateRatio(purchaseCount)
        ResultView.showRatio(calculateRatio)
    }
}
