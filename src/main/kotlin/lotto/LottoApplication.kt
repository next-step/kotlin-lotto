package lotto

import lotto.domain.LotteryStatistician
import lotto.domain.LottoGeneratorImpl
import lotto.domain.LottoSeller
import lotto.domain.QuantityChanger
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication {

    private val lottoSeller = LottoSeller(
        quantityChanger = QuantityChanger(),
        lottoGenerator = LottoGeneratorImpl(),
    )

    fun run() {
        val purchaseAmount = InputView.showAndGetPurchaseAmount()
        val lotties = lottoSeller.purchase(purchaseAmount)
        ResultView.printPurchaseLotties(lotties)

        val statistician = LotteryStatistician(InputView.showAndGetTargetLotto())
        ResultView.printStatistics(statistician.statistics(lotties))
    }

}

fun main() {
    LottoApplication().run()
}
