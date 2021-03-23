package lottery.controller

import lottery.domain.BonusBall
import lottery.domain.LotteryMatcher
import lottery.domain.Profit
import lottery.domain.LotteryFactory
import lottery.domain.RandomNumbersGenerator
import lottery.domain.WinnerLottery
import lottery.view.InputView
import lottery.view.InputView.printInputBonusBall
import lottery.view.InputView.printInputLastWinnerLottery
import lottery.view.Reception
import lottery.view.ResultView
import lottery.view.ResultView.printMatchNumbers

fun main() {
    InputView.printInputPrice()
    val inputMoney = Reception.receiveNumber()

    val factory = LotteryFactory(inputMoney)
    ResultView.printCountOfBuyLottery(factory.calculateLotteryCountByPrice())

    val createdTicket = factory.buy(RandomNumbersGenerator)
    val lotteries = createdTicket.lotteries

    ResultView.printLotteriesNumbers(lotteries)

    printInputLastWinnerLottery()
    val receiveWinnerLottery = Reception.receiveWinnerLottery()

    printInputBonusBall()
    val inputBonusBall = Reception.receiveNumber()

    val winnerLottery = WinnerLottery(receiveWinnerLottery, BonusBall(inputBonusBall))

    val lotteryMatcher = LotteryMatcher(winnerLottery, lotteries)

    val bonusBall = BonusBall(inputBonusBall)

    val rankCounts = lotteryMatcher.match(bonusBall)

    printMatchNumbers(rankCounts)

    val profit = Profit.calculate(inputMoney, rankCounts.calculateJackpots())
    ResultView.printProfit(profit)
}
