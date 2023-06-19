import domain.Lottery
import domain.Prize
import domain.Settlement
import view.InputView
import view.OutputView

class LotteryController(
    private val inputView: InputView = InputView(),
) {
    private var purchaseAmount = 0
    fun startLotteryService() {
        val lotteries = purchaseLotteries()
        val prizeCountMap = checkLotteriesWin(lotteries)

        for (prize in Prize.values()) OutputView.reportPrize(prize.prizeMessage, prizeCountMap[prize] ?: 0)

        val profitRate = Settlement.calculateProfitRate(prizeCountMap, purchaseAmount)
        OutputView.reportProfit(profitRate)
    }

    private fun purchaseLotteries(): List<Lottery> {
        val (purchaseAmount, lotteries) = LotteryMachine.buyLotteries(rechargeAccount())
        lotteries.forEach { lottery -> OutputView.reportPrizeState(lottery) }
        this.purchaseAmount = purchaseAmount
        return lotteries
    }

    private fun rechargeAccount(): Int {
        val money = inputView.inputMoney()
        require(money >= 1000) { "금액은 1,000보다 커야 합니다." }

        val purchasableCount = money / 1000
        OutputView.reportPurchaseCount(purchasableCount)
        return money
    }

    private fun checkLotteriesWin(lotteries: List<Lottery>): MutableMap<Prize, Int> {
        val winningNums = inputView.getWinningNums()
        val bonusBall = inputView.getBonusBall()
        require(bonusBall in 1..45) { "보너스 볼은 1부터 45사이의 값이여야합니다: $bonusBall" }
        return LotteryMachine.checkLotteriesWin(lotteries, winningNums, bonusBall)
    }
}
