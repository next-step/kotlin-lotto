package lottery.controller

import lottery.domain.LotteryMachine
import lottery.domain.LotteryTicketConverter.convertToTickets
import lottery.domain.Money
import lottery.domain.WinningTicket
import lottery.view.InputView.inputPurchaseAmount
import lottery.view.InputView.inputWinningLotteryNumbers
import lottery.view.ResultView.printLotteries
import lottery.view.ResultView.printStatistic
import lottery.view.ResultView.printTicketCount

fun main() {
    val purchaseAmount = Money(inputPurchaseAmount())
    val tickets = convertToTickets(purchaseAmount)
    printTicketCount(tickets)

    val lotteries = LotteryMachine.buy(tickets)
    printLotteries(lotteries)

    val winningTicket = WinningTicket.create(inputWinningLotteryNumbers())
    printStatistic(purchaseAmount, winningTicket.draw(lotteries))
}
