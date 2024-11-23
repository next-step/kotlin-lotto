package lottery.controller

import lottery.domain.LotteryMachine
import lottery.domain.LotteryTicketConverter.convertToTickets
import lottery.domain.Money
import lottery.view.InputView.inputPurchaseAmount
import lottery.view.ResultView.printLotteries
import lottery.view.ResultView.printTicketCount

fun main() {
    val purchaseAmount = inputPurchaseAmount()
    val tickets = convertToTickets(Money(purchaseAmount))
    printTicketCount(tickets)
    val lotteries = LotteryMachine.buy(tickets)
    printLotteries(lotteries)
}
