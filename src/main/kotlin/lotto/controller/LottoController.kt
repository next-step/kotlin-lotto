package lotto.controller

import lotto.domain.LottoPurchase
import lotto.domain.LottoPurchase.Companion.DEFAULT_PRICE
import lotto.domain.Lottos
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val lottoPurchase = LottoPurchase()

    fun run() {
        val budget = inputView.inputPurchasePrice()
        val lottos = buyLottos(budget)
        val winningLotto = inputView.inputLastWeekWinningLotto()

        val statistics = winningLotto.calculateStatistics(lottos, budget)
        resultView.printWinningResult(statistics)
    }

    private fun buyLottos(budget: Int): Lottos {
        val amount = lottoPurchase.affordableLottoCount(budget, DEFAULT_PRICE)
        val lottos = lottoPurchase.purchaseAuto(budget, DEFAULT_PRICE)

        resultView.printPurchaseAmount(amount)
        resultView.printLottos(lottos.lottos)

        return lottos
    }
}

fun main() {
    LottoController().run()
}
