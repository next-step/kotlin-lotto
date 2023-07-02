package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.receivePurchaseAmount()
    val gameCount = LottoGame.getGameCount(purchaseAmount)

    ResultView.printGameCount(gameCount)

    val lottoNumbers = List(gameCount) { LottoGame.generateRandomNumbers() }

    ResultView.printAllLottoNumbers(lottoNumbers)

    val winningNumbers = InputView.receiveWinningNumbers()
    val lottoGame = LottoGame(winningNumbers)
    val lottoGameStatistics = LottoGameStatistics(purchaseAmount, lottoGame.calculate(lottoNumbers))

    ResultView.printLottoResultStatistics(lottoGameStatistics)
}
