package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoPurchase
import lotto.domain.LottoPurchase.Companion.DEFAULT_PRICE
import lotto.domain.LottoStatistics
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val lottoPurchase = LottoPurchase()

    fun run() {
        val budget = inputView.inputPurchasePrice()
        val lottos = buyLottos(budget)
        val winningLotto = inputView.inputLastWeekLottoNumbers()

        showWinningResult(budget, lottos, winningLotto)
    }

    private fun buyLottos(budget: Int): List<Lotto> {
        val amount = lottoPurchase.affordableLottoCount(budget, DEFAULT_PRICE)
        val lottos = lottoPurchase.purchaseAuto(budget, DEFAULT_PRICE)

        resultView.printPurchaseAmount(amount)
        resultView.printLottos(lottos)

        return lottos
    }

    private fun showWinningResult(budget: Int, lottos: List<Lotto>, winningLotto: Lotto) {
        val statistics = LottoStatistics(lottos, budget, winningLotto)
        resultView.printWinningResult(statistics)
    }
}

fun main() {
    LottoController().run()
}
