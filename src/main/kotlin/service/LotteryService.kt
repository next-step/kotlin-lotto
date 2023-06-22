package service

import domain.Lottery
import domain.LottoDraw
import domain.Order
import domain.WinningFinder
import view.InputView
import view.OutputView

object LotteryService {
    fun createOrder(): Order {
        val money = InputView.inputMoney()
        val manualSize = InputView.inputManualSize()
        val manualLotteries = InputView.inputManualNums(manualSize)

        return Order(money, manualSize, manualLotteries)
    }

    fun purchaseByOrder(order: Order): List<Lottery> {
        val lotteries = LotteryMachine.buyAutomaticLotteries(order.autoSize(), order.manualLotteries)
        OutputView.reportPurchaseCount(order.manualSize, lotteries.size)
        lotteries.forEach { lottery -> OutputView.reportPrizeState(lottery) }

        return lotteries
    }

    fun checkAndCountLotto(lotteries: List<Lottery>): Map<Int, Int> {
        val winningNums = InputView.getWinningNums()
        val bonusBall = InputView.getBonusBall()
        val lottoDraw = LottoDraw(winningNums, bonusBall)
        val winningFinder = WinningFinder(lottoDraw)

        return LotteryCalculator.calculatePrizes(lotteries, winningFinder)
    }

    fun reportResult(prizeCountMap: Map<Int, Int>, lotteriesSize: Int) {
        OutputView.reportPrizes(prizeCountMap)
        val investment = lotteriesSize * 1_000
        OutputView.reportProfit(Settlement.calculateProfitRate(prizeCountMap, investment))
    }
}
