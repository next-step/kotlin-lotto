package lottery.controller

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

    val lotteries = LotteryMachine.buy(tickets)
    printLotteries(lotteries)

    val winningLottery = WinningLottery.create(inputWinningLotteryNumbers())
    printStatistic(purchaseAmount, winningLottery.draw(lotteries))
}
