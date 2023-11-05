package lotto

import lotto.domain.LottoBooth
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoList = LottoBooth.publishLottos(purchaseAmount)
    ResultView.printLottoList(lottoList)
    val winningNumbers = InputView.getWinningNumbers()
    val result = lottoList.getResult(winningNumbers)
    ResultView.printResult(result = result, purchaseAmount = purchaseAmount)
}
