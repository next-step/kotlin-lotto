package lotto.controller

import lotto.domain.LottoPrice
import lotto.domain.LottoPurchaseManager
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView().readPurchaseAmount()

    val manualCount = InputView().readManualLottoCount()
    val manualLottos = InputView().readManualLottoNumbers(manualCount)

    val lottos = LottoService(LottoPurchaseManager()).purchase(LottoPrice(purchaseAmount), manualLottos)
    ResultView().printPurchaseResult(manualCount, lottos)

    val winningNumbers = InputView().readWinningNumbers()
    val bonusBall = InputView().readBonusBall(winningNumbers)
    val winningResult = LottoService(LottoPurchaseManager()).checkWinning(lottos, winningNumbers, bonusBall)

    ResultView().printWinningStatistics(winningResult)
    ResultView().printProfitRate(winningResult.calculateProfitRate(purchaseAmount))
}
