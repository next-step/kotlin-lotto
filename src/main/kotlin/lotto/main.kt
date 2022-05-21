package lotto

import lotto.domain.LottoBuyer
import lotto.domain.WinningNumber
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val amountOfMoney = InputView.readAmountOfMoney()
    val lottoBuyer = LottoBuyer(amountOfMoney)
    OutputView.showLottoBundle(lottoBuyer.buyAll())
    val numbers = InputView.readWinningNumbers()
    val winningResult = lottoBuyer.confirmWinning(WinningNumber(numbers))
    OutputView.showWinningResult(winningResult)
}
