package lotto

import lotto.domain.LottoCalculator
import lotto.domain.LottoGenerator
import lotto.domain.LottoResultManager
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val totalPurchaseAmount = InputView.readTotalPurchaseAmountAsInt()
    val totalPurchaseCount =
        LottoCalculator().calculateLottoCount(
            totalPurchaseAmount = totalPurchaseAmount,
            pricePerAmount = 1000,
        )

    ResultView.printTotalPurchaseCount(totalPurchaseCount)

    val lottoGenerator = LottoGenerator(totalPurchaseCount)
    val lottoList = lottoGenerator.generate()
    ResultView.printLottoNumbers(lottoList)

    val winningLotto = InputView.readWinningLotto(InputView.ENTER_LAST_WINNING_NUMBER)
    val lottoResultManager =
        LottoResultManager(
            winningLotto = Lotto(winningLotto),
            lottoList = lottoList,
        )
    ResultView.printLottoResult(lottoResultManager.getResult())
    ResultView.printWinningRate(lottoResultManager.getWinningRate())
}
