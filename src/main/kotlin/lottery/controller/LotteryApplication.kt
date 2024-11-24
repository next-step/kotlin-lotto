package lottery.controller

import lottery.domain.DrawResult
import lottery.domain.LotteryMachine
import lottery.domain.Money
import lottery.domain.TicketMachine
import lottery.domain.WinningLottery
import lottery.view.InputView.inputPurchaseAmount
import lottery.view.InputView.inputWinningLotteryNumbers
import lottery.view.ResultView.printLotteries
import lottery.view.ResultView.printStatistic
import lottery.view.ResultView.printTicketCount

fun main() {
    val purchaseAmount = Money(inputPurchaseAmount())
    val tickets = TicketMachine.exchange(purchaseAmount)
    printTicketCount(tickets)

    val purchaseLotteries = LotteryMachine.purchase(tickets)
    printLotteries(purchaseLotteries)

    val winningLottery = WinningLottery.create(inputWinningLotteryNumbers())
    val drawResult = DrawResult.from(winningLottery, purchaseLotteries)
    printStatistic(purchaseAmount, drawResult)
}
