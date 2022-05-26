package lotto

import lotto.application.LotteryRandomGenerator
import lotto.application.LotteryStatistic
import lotto.application.WinningAnnouncer
import lotto.ui.LotteryRandomGeneratorView
import lotto.ui.LotteryStatisticView
import lotto.ui.LottoInputView

object LotteryApp {
    fun launch() {
        val (investment, numberOfLotteries) = LottoInputView.getPurchaseAmount()
        val generatedLotteries = LotteryRandomGenerator.generateLotteryTickets(numberOfLotteries)
        LotteryRandomGeneratorView.display(generatedLotteries)

        val winner = LottoInputView.getWinningLotteryNumber()
        val winnerMarkedLotteries = WinningAnnouncer.announce(winner, generatedLotteries)

        val priceGroupedLotteries = LotteryStatistic.getPriceGroupedLotteries(winnerMarkedLotteries)
        val earningRate = LotteryStatistic.getEarningRate(investment, priceGroupedLotteries)
        LotteryStatisticView.display(priceGroupedLotteries, earningRate)
    }
}

fun main() {
    LotteryApp.launch()
}
