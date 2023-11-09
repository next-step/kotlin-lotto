package lotto

import lotto.domain.LottoResultCalculator
import lotto.domain.LottoVendingMachine
import lotto.domain.RandomLottoGenerator
import lotto.domain.WinningLotto
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val amount = InputView.inputAmount()
    val manualLottoCount = InputView.inputManualLottoCount()
    val manualLottos = InputView.inputManualLottoNumber(manualLottoCount)

    val lottos = LottoVendingMachine(RandomLottoGenerator()).generate(amount, manualLottoCount)
    ResultView.printLottos(lottos)

    val inputWinningNumbers = InputView.inputWinningNumbers()
    val bonusNumber = InputView.inputBonusNumber()
    val winningLotto = WinningLotto(inputWinningNumbers, bonusNumber)
    val resultCalculator = LottoResultCalculator(winningLotto)
    val result = resultCalculator.calculateResult(lottos)

    ResultView.printResult(result)
    val earningRate = resultCalculator.calculateEarningRate(result, amount)
    ResultView.printEarningRate(earningRate)
}
