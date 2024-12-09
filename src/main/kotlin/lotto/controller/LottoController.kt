package lotto.controller

import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView().readPurchaseAmount()
    val lottos = LottoService().purchase(purchaseAmount)
    ResultView().printPurchaseResult(lottos)

    val winningNumbers = InputView().readWinningNumbers()
    val winningResult = LottoService().calculateWinningResult(lottos, winningNumbers)

    ResultView().printWinningStatistics(winningResult)
    ResultView().printProfitRate(winningResult.calculateProfitRate(purchaseAmount))
}
