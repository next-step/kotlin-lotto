package lotto

import lotto.domain.Lottery
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.order.PurchaseOrder
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseOrder = PurchaseOrder(amountText = InputView.readPurchaseAmount())
    val purchasedLotteries = purchaseOrder.purchasedLotteries

    ResultView.printPurchaseResult(purchasedLotteries = purchasedLotteries)

    val lastWeekWinningLottery = Lottery(lotteryText = InputView.readLastWeekWinningNumbers())
    val bonusBall = LottoNumber(numberText = InputView.readBonusBall())

    val lottoResult = LottoResult(
        purchasedLotteries = purchasedLotteries,
        winningLottery = lastWeekWinningLottery,
        bonusBall = bonusBall,
    )

    ResultView.printLottoResult(lottoResult = lottoResult)
}
