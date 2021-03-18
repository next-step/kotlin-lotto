package lottery.controller

import lottery.domain.LotteryFactory
import lottery.domain.LotteryMatcher
import lottery.domain.Rank
import lottery.domain.WinnerLottery
import lottery.domain.Profit
import lottery.view.InputView
import lottery.view.InputView.printInputLastWinnerLottery
import lottery.view.ResultView
import lottery.view.ResultView.printMatchNumbers

fun main() {
    InputView.printInputPrice()
    val inputMoney = Reception.receiveNumber()

    val factory = LotteryFactory(inputMoney)
    ResultView.printCountOfBuyLottery(factory.calculateLotteryCountByPrice())

    val createdTicket = factory.buy()
    val lotteries = createdTicket.lotteries

    ResultView.printLotteriesNumbers(lotteries)

    printInputLastWinnerLottery()
    val receiveWinnerLottery = Reception.receiveWinnerLottery()
    val winnerLottery = WinnerLottery(receiveWinnerLottery)

    val lotteryMatcher =
        LotteryMatcher(winnerLottery, lotteries)

    val inputBonusBall = Reception.receiveNumber()
    val rankCounts = lotteryMatcher.match(inputBonusBall)

    printMatchNumbers(Rank.FIFTH.matchCount, Rank.FIRST.matchCount, rankCounts)

    val profit = Profit.calculate(inputMoney, rankCounts.calculateJackpots())
    ResultView.printProfit(profit)
}
