package lotto

import lotto.domain.LotteryStatistician
import lotto.domain.LottoGeneratorImpl
import lotto.domain.LottoManager
import lotto.domain.QuantityChanger
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication {

    private val lottoManager = LottoManager(
        quantityChanger = QuantityChanger(),
        lottoGenerator = LottoGeneratorImpl(),
    )

    fun run() {
        val purchaseAmount = InputView.showAndGetPurchaseAmount()
        val lotties = lottoManager.purchase(purchaseAmount)
        ResultView.printPurchaseLotties(lotties)

        val statistician = LotteryStatistician(InputView.showAndGetTargetLotto())
        ResultView.printStatistics(statistician.check(purchaseAmount, lotties))
    }

}

fun main() {
    LottoApplication().run()
}
