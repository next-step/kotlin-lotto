package lotto

import lotto.domain.LottoResultCalculator
import lotto.domain.LottoVendingMachine
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val amount = InputView.inputAmount()
    val lottos = LottoVendingMachine.generate(amount)
    ResultView.printLottos(lottos)

    val inputWinningNumbers = InputView.inputWinningNumbers()
    val resultCalculator = LottoResultCalculator(inputWinningNumbers)
    val result = resultCalculator.calculateResult(lottos)

    ResultView.printResult(result)
    val earningRate = resultCalculator.calculateEarningRate(result, amount)
    ResultView.printEarningRate(earningRate)
}
