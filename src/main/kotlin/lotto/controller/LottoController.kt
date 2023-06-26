package lotto.controller

import lotto.domain.LottoPurchase
import lotto.domain.LottoPurchase.Companion.DEFAULT_PRICE
import lotto.domain.Lottos
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    private val inputView = InputView()
    private val resultView = ResultView()

    fun run() {
        val budget = inputView.inputPurchasePrice()
        val lottos = buyLottos(budget)
        val winningLotto = inputView.inputLastWeekWinningLotto()

        val statistics = winningLotto.calculateStatistics(lottos, budget)
        resultView.printWinningResult(statistics)
    }

    private fun buyLottos(budget: Int): Lottos {
        val manualAmount = inputView.inputManualPurchaseAmount()
        val manualLottosNumbers = inputView.inputManualLottos(manualAmount)
        val lottoPurchase = LottoPurchase(budget, DEFAULT_PRICE, manualLottosNumbers)

        val allLottos = lottoPurchase.purchaseManualAndAuto()
        resultView.printPurchaseAmount(allLottos.countManualLottos(), allLottos.countAutoLottos())
        resultView.printLottos(allLottos.lottos)

        return allLottos
    }
}

fun main() {
    LottoController().run()
}
