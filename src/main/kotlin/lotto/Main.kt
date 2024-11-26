package lotto

import lotto.domain.LottoCalculator
import lotto.domain.LottoGenerator
import lotto.domain.LottoResultManager
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val totalPurchaseAmount = inputView.readTotalPurchaseAmount().toInt()
    val totalPurchaseCount =
        LottoCalculator().calculateLottoCount(
            totalPurchaseAmount = totalPurchaseAmount,
            pricePerAmount = 1000,
        )
    resultView.printTotalPurchaseCount(
        count = totalPurchaseCount,
    )

    val lottoGenerator = LottoGenerator(totalPurchaseCount)
    val lottoList = lottoGenerator.generate()
    resultView.printLottoNumbers(
        list = lottoList,
    )

    val winningLotto =
        inputView.readWinningLotto(
            promptMessage = InputView.ENTER_LAST_WINNING_NUMBER,
        )
    val lottoResultManager =
        LottoResultManager(
            winningLotto = Lotto(winningLotto),
            lottoList = lottoList,
        )
    resultView.printLottoResult(
        lottoResultMap = lottoResultManager.getResult().lottoResultMap,
    )
    resultView.printWinningRate(
        winningRate = lottoResultManager.calculateWinningRate(),
    )
}
