package lotto.controller

import lotto.domain.LotteryChecker
import lotto.domain.LotteryNumber
import lotto.domain.Store
import lotto.domain.EarningsRateCalculator
import lotto.domain.EarningsRateCalculator.isLoss
import lotto.view.InputView.getPurchase
import lotto.view.InputView.getWinningNumbers
import lotto.view.ResultView.printLotteries
import lotto.view.ResultView.printStatistics
import lotto.view.ResultView.printEarningRate

fun main() {

    val purchase = getPurchase()
    val lotteries = Store.buy(purchase)
    printLotteries(lotteries)

    val winningNumbers = getWinningNumbers().map { LotteryNumber(it) }
    val lotteryChecker = LotteryChecker(winningNumbers, lotteries)
    val result = lotteryChecker.run()
    printStatistics(result)

    val earningRate = EarningsRateCalculator.run(result, purchase)
    printEarningRate(earningRate = earningRate, isLoss = isLoss(earningRate))
}
