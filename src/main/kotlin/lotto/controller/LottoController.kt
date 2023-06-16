package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoPrizes
import lotto.domain.LottoPurchase
import lotto.domain.LottoStatistics
import lotto.domain.WinningLotto
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
        val amount = LottoPurchase.affordableLottoCount(budget)
        val lottos = lottoPurchase.purchaseAuto(amount)

        resultView.printPurchaseAmount(amount)
        resultView.printLottos(lottos)

        return lottos
    }

    private fun showWinningResult(budget: Int, lottos: List<Lotto>, winningLotto: WinningLotto) {
        val statistics = LottoStatistics(lottos, winningLotto)

        resultView.printWinningStatistics(statistics)
        resultView.printRateOfReturn(budget, statistics.totalPrizes)
    }
}

fun main() {
    LottoController().run()
}
