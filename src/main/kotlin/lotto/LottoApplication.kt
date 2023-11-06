package lotto

import lotto.domain.Lotto
import lotto.domain.LottoResultCalculator
import lotto.domain.LottoVendingMachine
import lotto.domain.RandomLottoGenerator
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val amount = InputView.inputAmount()
    val lottos = LottoVendingMachine(RandomLottoGenerator()).generate(amount)
    ResultView.printLottos(lottos)

    val inputWinningNumbers = InputView.inputWinningNumbers()
    val bonusNumber = InputView.inputBonusNumber()
    val resultCalculator = LottoResultCalculator(Lotto(inputWinningNumbers), bonusNumber)
    val result = resultCalculator.calculateResult(lottos)

    ResultView.printResult(result)
    val earningRate = resultCalculator.calculateEarningRate(result, amount)
    ResultView.printEarningRate(earningRate)
}
