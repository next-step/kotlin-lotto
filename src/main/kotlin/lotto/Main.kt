package lotto

import lotto.domain.LottoBooth
import lotto.domain.LottoBuyStrategy
import lotto.domain.LottoResultList
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val manualCount = InputView.getManualLottoCount()
    val buyStrategy = LottoBuyStrategy(purchaseAmount, InputView.getManualLottoNumbers(manualCount))

    val lottoList = LottoBooth.publishLottos(buyStrategy)
    ResultView.printLottoList(lottoList)

    val winningNumbers = InputView.getWinningNumbers()
    val result = LottoResultList.getResult(winningNumbers, lottoList)
    ResultView.printResult(result = result, purchaseAmount = purchaseAmount)
}
