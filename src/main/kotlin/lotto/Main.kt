package lotto

import lotto.domain.LottoCalculator
import lotto.domain.LottoGenerator
import lotto.domain.LottoResultStore
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val totalPurchaseAmount = InputView.readTotalPurchaseAmountAsInt()
    val calculator = LottoCalculator(totalPurchaseAmount, 1000)
    val totalPurchaseCount = calculator.calculateLottoCount()

    ResultView.printTotalPurchaseCount(totalPurchaseCount)

    val generator = LottoGenerator(totalPurchaseCount)
    val generatedLottoList = generator.generate()

    ResultView.printLottoNumbers(generatedLottoList)

    val winningLotto = InputView.readWinningLotto(InputView.ENTER_LAST_WINNING_NUMBER)
    val resultStore = LottoResultStore(Lotto(winningLotto), generatedLottoList)
    val result = resultStore.getResult()

    ResultView.printLottoResult(result)
    ResultView.printWinningRate(calculator.calculateWinningRateFromResult(result.getSum()))
}
