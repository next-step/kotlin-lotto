package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    PlayLotto().run()
}

class PlayLotto {
    private val lottoGame = LottoGame()
    private val inputView = InputView()
    private val resultView = ResultView()

    fun run() {
        val purchaseAmount = inputView.readPurchaseAmount()
        val lottos = lottoGame.purchase(purchaseAmount)
        resultView.printPurchaseResult(lottos)

        val winningNumbers = inputView.readWinningNumbers()
        val winningResult = lottoGame.calculateWinningResult(lottos, winningNumbers)

        resultView.printWinningStatistics(winningResult)
        resultView.printProfitRate(winningResult.calculateProfitRate(purchaseAmount))
    }
}
