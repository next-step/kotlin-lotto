package lotto

import lotto.domain.LottoBuyer
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val amountOfMoney = InputView.readAmountOfMoney()
    val lottoBuyer = LottoBuyer(amountOfMoney)
    OutputView.showLottoBundle(lottoBuyer.buyAll())
    val winningNumbers = InputView.readWinningNumbers()
    val winningResult = lottoBuyer.confirmWinning(winningNumbers)
    OutputView.showWinningResult(winningResult)
}
