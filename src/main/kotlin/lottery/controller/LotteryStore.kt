package lottery.controller

import lottery.domain.Numbers
import lottery.domain.RandomNumbersGenerator
import lottery.domain.LotteryNumbers
import lottery.domain.BonusBall
import lottery.domain.Profit
import lottery.domain.Lottery
import lottery.domain.LotteryFactory
import lottery.domain.RankCounts
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

    InputView.printInputCountOfManualLottery()
    val countOfManualLottery = Reception.receiveNumber()

    InputView.printInputManualLotteryNumbers()

    val manualLotteries = Reception.receiveManualLotteryNumbers(countOfManualLottery)

    printCountOfLotteries(factory, countOfManualLottery)

    val lotteries = buyLotteries(factory, manualLotteries)

    val receiveWinnerLottery = receiveWinnerLotteryNumbers()

    val winnerLottery = receiveWinnerLottery(receiveWinnerLottery)

    calculateProfit(lotteries, winnerLottery, inputMoney)
}

private fun calculateProfit(lotteries: List<Lottery>, winnerLottery: WinnerLottery, inputMoney: Int) {
    val rankCounts = RankCounts(lotteries, winnerLottery)
    printMatchNumbers(rankCounts)

    val profit = Profit.calculate(inputMoney, rankCounts.calculateJackpots())
    ResultView.printProfit(profit)
}

private fun receiveWinnerLottery(receiveWinnerLottery: List<Int>): WinnerLottery {
    printInputBonusBall()
    val inputBonusBall = Reception.receiveNumber()
    return WinnerLottery(receiveWinnerLottery, BonusBall(inputBonusBall))
}

private fun receiveWinnerLotteryNumbers(): List<Int> {
    printInputLastWinnerLottery()
    return Reception.receiveLotteryNumbers()
}

private fun buyLotteries(factory: LotteryFactory, manualLotteries: List<LotteryNumbers>): List<Lottery> {
    val createdTicket = factory.buy(RandomNumbersGenerator, Numbers(manualLotteries))
    val lotteries = createdTicket.lotteries

    ResultView.printLotteriesNumbers(lotteries)
    return lotteries
}

private fun printCountOfLotteries(factory: LotteryFactory, countOfManualLottery: Int) {
    val countOfLotteries = factory.calculateLotteryCountByPrice()
    val countOfAutoLotteries = factory.calculateAutoLotteryCount(countOfLotteries, countOfManualLottery)

    ResultView.printCountOfBuyLottery(countOfManualLottery, countOfAutoLotteries)
}
