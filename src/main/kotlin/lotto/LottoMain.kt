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

    val resultMap = lottoList.groupBy { winningLotto.calculatePrize(it) }
        .mapValues { it.value.size }

    val result = LottoResult(resultMap)

    ResultView.outputResult(purchaseAmount, result)
}
