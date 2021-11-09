package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoCount
import lotto.model.LottoNumber
import lotto.model.LottoNumberListGenerator
import lotto.model.LottoType
import lotto.model.Lottos
import lotto.model.Price
import lotto.model.WinNumber
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun runLottoGame() {
        val price = Price(inputView.takePurchasedPrice())
        val lottoCount = getLottoCount(price)
        val purchasedLottoList = generateLottos(lottoCount)
        printResult(price, purchasedLottoList)
    }

    private fun getLottoCount(price: Price): HashMap<LottoType, Int> {
        val inputManualLottoCount = inputView.inputManualLottoCount() ?: 0
        val manualCount = LottoCount(price.lottoCount).createLottoNumber(inputManualLottoCount)
        val autoCount = LottoCount(price.lottoCount - manualCount).createLottoNumber()

        return hashMapOf(
            LottoType.MANUAL to manualCount,
            LottoType.AUTO to autoCount
        )
    }

    private fun generateLottos(lottoCount: HashMap<LottoType, Int>): List<Lotto> {
        val manualLottoCount = lottoCount[LottoType.MANUAL] ?: 0
        val autoLottoCount = lottoCount[LottoType.AUTO] ?: 0

        val manualLottoStrings = inputView.inputManualLottoNumber(manualLottoCount)
        val manualLottoList = LottoNumberListGenerator.generateManualLottoList(manualLottoStrings)
        val autoLottoList = LottoNumberListGenerator.generateAutoLottoList(autoLottoCount, LottoNumber.getLottoNumberRange())

        outputView.printWinNumbers(manualLottoList, autoLottoList)
        outputView.resultLottoCount(manualLottoCount, autoLottoCount)
        return manualLottoList.plus(autoLottoList)
    }

    private fun printResult(price: Price, purchasedLotto: List<Lotto>) {
        val winNumberList = inputView.inputLastLottoWinNumber()
        val bonusNumber = inputView.inputBonusNumber()
        val winNumber = WinNumber.inputWinNumber(winNumberList, bonusNumber)
        val lottos = Lottos.executeLottoComparison(purchasedLotto)
        val result = lottos.compareLottoResult(price, winNumber)
        outputView.printWinStatistic(result)
    }
}
