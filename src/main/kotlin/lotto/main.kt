package lotto

import lotto.domain.LottoBuyer
import lotto.domain.WinningLotto
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val amountOfMoney = InputView.readAmountOfMoney()
    val lottoBuyer = LottoBuyer(amountOfMoney)
    lottoBuyer.buyAll()
    OutputView.showPurchasedLottoBundle(lottoBuyer.getLottoBundle())
    val numbers = InputView.readWinningNumbers()
    val bonusBall = InputView.readBonusBall()
    val winningResult = lottoBuyer.confirm(WinningLotto.from(numbers, bonusBall))
    OutputView.showWinningResult(winningResult)
}
