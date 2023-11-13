package lotto

import lotto.domain.LottoBooth
import lotto.domain.LottoResultList
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val buyStrategy = InputView.getBuyStrategy(purchaseAmount)

    val lottoList = LottoBooth.publishLottos(buyStrategy)
    ResultView.printLottoList(lottoList)

    val winningNumbers = InputView.getWinningNumbers()
    val result = LottoResultList.getResult(winningNumbers, lottoList)
    ResultView.printResult(result = result, purchaseAmount = purchaseAmount)
}
