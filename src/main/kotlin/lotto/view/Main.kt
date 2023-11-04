package lotto.view

import lotto.LottoBooth

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoList = LottoBooth.publishLottos(purchaseAmount)
    ResultView.printLottoList(lottoList)
    val winningNumbers = InputView.getWinningNumbers()
    val result = lottoList.getResult(winningNumbers)
    ResultView.printResult(result = result, purchaseAmount = purchaseAmount)
}
