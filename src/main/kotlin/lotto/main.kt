package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.WinningLottery
import lotto.domain.order.PurchaseOrder
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseOrder = PurchaseOrder(amountText = InputView.readPurchaseAmount())
    val purchasedLotteries = purchaseOrder.purchasedLotteries

    ResultView.printPurchaseResult(purchasedLotteries = purchasedLotteries)

    val winningLottery = WinningLottery(
        lotteryText = InputView.readLastWeekWinningNumbers(),
        bonusBall = LottoNumber(numberText = InputView.readBonusBall()),
    )

    val lottoResult = LottoResult(
        purchasedLotteries = purchasedLotteries,
        winningLottery = winningLottery,
    )

    ResultView.printLottoResult(lottoResult = lottoResult)
}
