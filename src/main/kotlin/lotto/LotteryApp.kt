package lotto

import lotto.application.LotteryRandomGenerator
import lotto.ui.LotteryRandomGeneratorView
import lotto.ui.LotteryStatisticView
import lotto.ui.LottoInputView

object LotteryApp {
    fun launch() {
        val (investment, numberOfLotteries) = LottoInputView.getPurchaseAmount()
        val generatedLotteries = LotteryRandomGenerator.generateLotteryTickets(numberOfLotteries)
        LotteryRandomGeneratorView.display(generatedLotteries)

        val winner = LottoInputView.getWinningLotteryNumber()
        val bonusNumber = LottoInputView.getBonusNumber()

        val (priceGroupedLotteries, earningRate) = generatedLotteries.getProfit(investment, winner, bonusNumber)
        LotteryStatisticView.display(priceGroupedLotteries, earningRate)
    }
}

fun main() {
    LotteryApp.launch()
}
