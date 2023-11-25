package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoResult
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoNumberGenerator = LottoNumberGenerator()
    val lottoList = LottoMachine.generateLotto(purchaseAmount, lottoNumberGenerator)

    ResultView.printLottoList(lottoList.toSet())

    val winningLotto = InputView.getWinningNumbers()

    val result = LottoResult()
    lottoList.groupBy {
        val prize = winningLotto.calculatePrize(it)
        result.updateResult(prize)
    }
    ResultView.outputResult(purchaseAmount, result)
}
