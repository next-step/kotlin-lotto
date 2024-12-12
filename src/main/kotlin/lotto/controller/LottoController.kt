package lotto.controller

import lotto.domain.LottoPrice
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView().readPurchaseAmount()
    val lottos = LottoService().purchase(LottoPrice(purchaseAmount))
    ResultView().printPurchaseResult(lottos)

    val winningNumbers = InputView().readWinningNumbers()
    val bonusBall = InputView().readBonusBall(winningNumbers) // 보너스볼 입력 추가
    val winningResult = LottoService().checkWinning(lottos, winningNumbers, bonusBall) // 보너스볼 전달

    ResultView().printWinningStatistics(winningResult)
    ResultView().printProfitRate(winningResult.calculateProfitRate(purchaseAmount))
}
