package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.receivePurchaseAmount()
    val gameCount = LottoGame.getGameCount(purchaseAmount)

    ResultView.printGameCount(gameCount)

    val randomLottoNumbersGenerator = RandomGenerator()
    val lottoNumbers = List(gameCount) { randomLottoNumbersGenerator.generate() }

    ResultView.printAllLottoNumbers(lottoNumbers)

    val winningNumbers = InputView.receiveWinningNumbers()
    val lottoGame = LottoGame(winningNumbers)
    val lottoGameStatistics = LottoGameStatistics(purchaseAmount, lottoGame.calculate(lottoNumbers))

    ResultView.printLottoResultStatistics(lottoGameStatistics)
}
