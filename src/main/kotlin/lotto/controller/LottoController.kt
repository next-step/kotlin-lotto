package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoPrizes
import lotto.domain.LottoPurchase
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
        val countsMap = mutableMapOf<Int, Int>()
        var totalPrizes = 0

        lottos.forEach {
            val equalCount = winningLotto.checkEqualCount(it.numbers)
            countsMap[equalCount] = countsMap.getOrDefault(equalCount, 0) + 1

            val prize = LottoPrizes.getMoney(equalCount)
            totalPrizes += prize
        }

        resultView.printWinningStatistics(countsMap)
        resultView.printRateOfReturn(budget, totalPrizes)
    }
}

fun main() {
    LottoController().run()
}
