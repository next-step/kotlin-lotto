package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoResult
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoNumberGenerator = LottoNumberGenerator()
    val manualLottos = InputView.getManaulLottos(purchaseAmount)
    val autoLottos = LottoMachine.generateLotto(purchaseAmount, lottoNumberGenerator)
    val lottos = ResultView.printLottoList(manualLottos, autoLottos)

    val winningLotto = InputView.getWinningNumbers()

    val resultMap = lottos.groupBy { winningLotto.calculatePrize(it) }
        .mapValues { it.value.size }
    val result = LottoResult(resultMap)

    ResultView.outputResult(purchaseAmount, result)
}
