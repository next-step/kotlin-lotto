package lotto

import lotto.domain.LottoBuyer
import lotto.domain.WinningLotto
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val amountOfMoney = InputView.readAmountOfMoney()
    val lottoBuyer = LottoBuyer(amountOfMoney)
    OutputView.showPurchasedLottoBundle(lottoBuyer.buyAll())
    val numbers = InputView.readWinningNumbers()
    val winningResult = lottoBuyer.confirmWinning(WinningLotto.from(numbers, 7))
    OutputView.showWinningResult(winningResult)
}
