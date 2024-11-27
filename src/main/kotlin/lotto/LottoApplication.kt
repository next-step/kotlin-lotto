package lotto

import lotto.domain.LotteryStatistician
import lotto.domain.LottoGeneratorImpl
import lotto.domain.LottoOffice
import lotto.domain.LottoStringParser
import lotto.domain.QuantityChangerImpl
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication {

    private val lottoStringParser = LottoStringParser()

    private val lottoOffice = LottoOffice(
        lottoStringParser = lottoStringParser,
        quantityChanger = QuantityChangerImpl(),
        lottoGenerator = LottoGeneratorImpl(),
    )

    fun run() {
        val purchaseAmount = InputView.showAndGetPurchaseAmount()
        val lotties = lottoOffice.purchase(purchaseAmount, getManualLottoNumbers())
        ResultView.printPurchaseLotties(lotties)

        val targetLotto = lottoStringParser.parse(InputView.showAndGetTargetLotto())
        val bonusNumber = InputView.showAndGetBonusNumber()
        val statistician = LotteryStatistician(targetLotto, bonusNumber)
        ResultView.printStatistics(statistician.statistics(lotties))
    }

    private fun getManualLottoNumbers(): List<String> {
        val manualCount = InputView.showAndGetManualCount()
        return if (manualCount > 0) {
            InputView.showAndGetManualLottoNumbers(manualCount)
        } else {
            listOf()
        }
    }

}

fun main() {
    LottoApplication().run()
}
