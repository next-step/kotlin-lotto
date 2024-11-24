package lotto

import lotto.domain.LotteryStatistician
import lotto.domain.LottoGeneratorImpl
import lotto.domain.LottoSeller
import lotto.domain.QuantityChangerImpl
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication {

    private val lottoSeller = LottoSeller(
        quantityChanger = QuantityChangerImpl(),
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
