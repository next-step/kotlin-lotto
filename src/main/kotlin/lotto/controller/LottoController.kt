package lotto.controller

import lotto.domain.LottoPrizes
import lotto.domain.LottoPurchase
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val lottoPurchase = LottoPurchase()

    fun run() {
        val budget = inputView.inputPurchasePrice()
        val purchaseAmount = LottoPurchase.affordableLottoCount(budget)

        val lottos = lottoPurchase.purchaseAuto(purchaseAmount)
        resultView.printPurchaseAmount(purchaseAmount)
        resultView.printLottos(lottos)

        val winningLotto = inputView.inputLastWeekLottoNumbers()

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
