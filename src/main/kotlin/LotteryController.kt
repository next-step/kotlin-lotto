import domain.Lottery
import domain.Prize
import domain.Settlement
import domain.WinningFinder
import view.InputView
import view.OutputView

class LotteryController(
    private val inputView: InputView = InputView(),
) {

    fun startLotteryService() {
        val lotteries = purchaseLotteries()
        val prizeCountMap = LotteryCalculator.calculatePrizes(lotteries, getWinningFinder())
        for (prize in Prize.values()) OutputView.reportPrize(prize.prizeMessage, prizeCountMap[prize.matches] ?: 0)
        OutputView.reportProfit(Settlement.calculateProfitRate(prizeCountMap, lotteries.size))
    }

    private fun purchaseLotteries(): List<Lottery> {
        val (money, manualSize) = inputMoneyAndManualSize()
        val manualLotteries = inputView.inputManualNums(manualSize)
        val lotteries = LotteryMachine.buyAutomaticLotteries(money / 1000 - manualSize, manualLotteries)
        reportPurchasedState(manualSize, lotteries)

        return lotteries
    }

    private fun inputMoneyAndManualSize(): Pair<Int, Int> {
        val money = inputView.inputMoney()
        val manualSize = inputView.inputManualSize()
        LotteryMachine.checkManualSize(money, manualSize)

        return Pair(money, manualSize)
    }

    private fun reportPurchasedState(manualSize: Int, lotteries: List<Lottery>) {
        OutputView.reportPurchaseCount(manualSize, lotteries.size)
        lotteries.forEach { lottery -> OutputView.reportPrizeState(lottery) }
    }

    private fun getWinningFinder(): WinningFinder {
        val winningNums = inputView.getWinningNums()
        val bonusBall = inputView.getBonusBall()
        require(bonusBall in 1..45) { "보너스 볼은 1부터 45사이의 값이여야합니다: $bonusBall" }

        return WinningFinder(winningNums, bonusBall)
    }
}
