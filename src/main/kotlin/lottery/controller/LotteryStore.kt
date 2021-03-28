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

    InputView.printInputCountOfManualLottery()
    val countOfManualLottery = Reception.receiveNumber()

    InputView.printInputManualLotteryNumbers()

    val manualLotteries = Reception.receiveManualLotteryNumbers(countOfManualLottery)

    val factory = LotteryFactory(inputMoney)
    val countOfLotteries = factory.calculateLotteryCountByPrice()
    val countOfAutoLotteries = factory.calculateAutoLotteryCount(countOfLotteries, countOfManualLottery)
    ResultView.printCountOfBuyLottery(countOfManualLottery, countOfAutoLotteries)

    val createdTicket = factory.buy(RandomNumbersGenerator, manualLotteries)
    val lotteries = createdTicket.lotteries

    ResultView.printLotteriesNumbers(lotteries)

    printInputLastWinnerLottery()
    val receiveWinnerLottery = Reception.receiveLotteryNumbers()

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
