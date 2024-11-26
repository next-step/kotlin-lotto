package lottery.controller

import lottery.domain.DrawResult
import lottery.domain.LotteryMachine
import lottery.domain.Money
import lottery.domain.TicketMachine
import lottery.domain.WinningLottery
import lottery.view.InputView
import lottery.view.ResultView

fun main() {
    val purchaseAmount = Money(InputView.inputPurchaseAmount())
    val tickets = TicketMachine.exchange(purchaseAmount)
    ResultView.printTicketCount(tickets)

    val purchaseLotteries = LotteryMachine.purchase(tickets)
    ResultView.printLotteries(purchaseLotteries)

    val winningLottery = WinningLottery.create(InputView.inputWinningLotteryNumbers())
    val drawResult = DrawResult.from(winningLottery, purchaseLotteries)
    ResultView.printStatistic(purchaseAmount, drawResult)
}
