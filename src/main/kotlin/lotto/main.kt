package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.WinningLottery
import lotto.domain.order.PurchaseOrder
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseOrder = PurchaseOrder(
        amountText = InputView.readPurchaseAmount(),
        manualLotteryTexts = InputView.readManualLotteryNumber(),
    )

    ResultView.printPurchaseResult(purchaseOrder = purchaseOrder)

    val winningLottery = WinningLottery(
        lotteryText = InputView.readLastWeekWinningNumbers(),
        bonusBall = LottoNumber(numberText = InputView.readBonusBall()),
    )

    val lottoResult = LottoResult(
        purchasedLotteries = purchaseOrder.purchasedLotteries(),
        winningLottery = winningLottery,
    )

    ResultView.printLottoResult(lottoResult = lottoResult)
}
