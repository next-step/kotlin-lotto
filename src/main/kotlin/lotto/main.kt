package lotto

import lotto.domain.LottoBuyer
import lotto.domain.LottoSeller
import lotto.domain.WinningLotto
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val amountOfMoney = InputView.readAmountOfMoney()
    val lottoBuyer = LottoBuyer(amountOfMoney)

    val numberOfManualLotto = InputView.readNumberOfManualLotto(
        LottoSeller.getAvailableAmountOfLotto(amountOfMoney)
    )
    val lottoCoupon = InputView.readLottoCoupons(numberOfManualLotto)
    lottoBuyer.buy(lottoCoupon)
    lottoBuyer.buyAll()
    OutputView.showPurchasedLottoBundle(numberOfManualLotto, lottoBuyer.getLottoBundle())

    val winningLotto = InputView.readWinningLotto()
    val bonusBall = InputView.readBonusBall()
    val winningResult = lottoBuyer.confirm(WinningLotto(winningLotto, bonusBall))

    OutputView.showWinningResult(winningResult)
}
