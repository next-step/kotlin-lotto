package lotto

import lotto.domain.LottoBuyer
import lotto.domain.WinningNumbers
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val amountOfMoney = InputView.readAmountOfMoney()
    val lottoBuyer = LottoBuyer(amountOfMoney)
    OutputView.showPurchasedLottoBundle(lottoBuyer.buyAll())
    val numbers = InputView.readWinningNumbers()
    val winningResult = lottoBuyer.confirmWinning(WinningNumbers.of(numbers))
    OutputView.showWinningResult(winningResult)
}
