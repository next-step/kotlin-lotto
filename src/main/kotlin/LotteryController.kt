import domain.Lottery
import domain.Prize
import domain.Settlement
import view.InputView
import view.OutputView

class LotteryController(
    private val inputView: InputView = InputView(),
) {

    fun startLotteryService() {
        val lotteries = purchaseLotteries()
        val prizeCountMap = checkLotteriesWin(lotteries)

        for (prize in Prize.values()) OutputView.reportPrize(prize.prizeMessage, prizeCountMap[prize] ?: 0)

        val profitRate = Settlement.calculateProfitRate(prizeCountMap, purchaseAmount)
        OutputView.reportProfit(profitRate)
    }

    private fun purchaseLotteries(): Pair<Int, List<Lottery>> {
        val (money, manualSize) = inputMoneyAndManualSize()
        val lotteries = inputView.inputManualNums(manualSize)
        LotteryMachine.buyAutomaticLotteries(lotteries.size - manualSize, lotteries)

        reportPurchasedState(manualSize, lotteries)

        val purchasedAmount = (money / 1000) * 1000
        return Pair(purchasedAmount, lotteries)
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

    private fun checkLotteriesWin(lotteries: List<Lottery>): MutableMap<Prize, Int> {
        val winningNums = inputView.getWinningNums()
        val bonusBall = inputView.getBonusBall()
        require(bonusBall in 1..45) { "보너스 볼은 1부터 45사이의 값이여야합니다: $bonusBall" }
        return LotteryMachine.checkLotteriesWin(lotteries, winningNums, bonusBall)
    }
}
