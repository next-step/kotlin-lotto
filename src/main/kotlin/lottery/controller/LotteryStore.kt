package lottery.controller

import lottery.domain.*
import lottery.view.InputView
import lottery.view.InputView.printInputLastWinnerLottery
import lottery.view.ResultView
import lottery.view.ResultView.printMatchNumbers

fun main() {
    InputView.printInputPrice()
    val inputMoney = Reception.receiveMoney()

    val factory = LotteryFactory(inputMoney)
    ResultView.printCountOfBuyLottery(factory.calculateLotteryCountByPrice())

    val createdTicket = factory.buy()
    val lotteries = createdTicket.lotteries

    ResultView.printLotteriesNumbers(lotteries)

    printInputLastWinnerLottery()
    val receiveWinnerLottery = Reception.receiveWinnerLottery()
    val winnerLottery = WinnerLottery(receiveWinnerLottery)

    val lotteryMatcher = LotteryMatcher(winnerLottery, lotteries)
    val rankCounts = lotteryMatcher.match()

    printMatchNumbers(Rank.FOURTH.matchCount, Rank.FIRST.matchCount, rankCounts)

    val profit = Profit.calculate(inputMoney, rankCounts.calculateJackpots())
    ResultView.printProfit(profit)
}
