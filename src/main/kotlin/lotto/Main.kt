package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.receivePurchaseAmount()
    val gameCount = LottoGame.getGameCount(purchaseAmount)

    ResultView.printGameCount(gameCount)

    val lottoNumbers = List(gameCount) { LottoNumbers.generateRandom() }

    ResultView.printAllLottoNumbers(lottoNumbers)

    val winningNumbers = InputView.receiveWinningNumbers()
    val lottoGame = LottoGame(lottoNumbers, winningNumbers)
    val lottoGameStatistics = LottoGameStatistics(purchaseAmount, lottoGame.result)

    ResultView.printLottoResultStatistics(lottoGameStatistics)
}