package lotto

import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.receivePurchaseAmount()

    val manualGameCount = InputView.receiveManualGameCount()
    val autoGameCount = LottoGame.getAutoGameCount(purchaseAmount, manualGameCount)

    val randomLottoNumbersGenerator = RandomGenerator()

    val manualLottoNumbers = InputView.receiveManualLottoNumbers(manualGameCount)
    val autoLottoNumbers = List(autoGameCount) { randomLottoNumbersGenerator.generate() }
    val lottoNumbers = manualLottoNumbers + autoLottoNumbers

    ResultView.printAllLottoNumbers(lottoNumbers)

    val winningNumbers = InputView.receiveWinningNumbers()
    val lottoGame = LottoGame(winningNumbers)
    val lottoGameStatistics = LottoGameStatistics(purchaseAmount, lottoGame.calculate(lottoNumbers))

    ResultView.printLottoResultStatistics(lottoGameStatistics)
}
