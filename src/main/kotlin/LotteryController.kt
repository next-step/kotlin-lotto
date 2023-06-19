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
        val (purchaseAmount, lotteries) = LotteryMachine.purchaseLotteries(rechargeAccount())
        lotteries.forEach { lottery -> OutputView.reportPrizeState(lottery) }
        this.purchaseAmount = purchaseAmount
        return lotteries
    }

    private fun rechargeAccount(): Int {
        val money = inputView.inputMoney()
        require(money >= 1000) { "Insufficient funds." }

        val purchasableCount = money / 1000
        OutputView.reportPurchaseCount(purchasableCount)
        return money
    }

    private fun checkLotteriesWin(lotteries: List<Lottery>): MutableMap<Prize, Int> {
        val winningNumbers = inputView.getWinningNumbers()
        val bonusNumber = inputView.getBonusNumber()
        require(bonusNumber in 1..45) { "Invalid bonus number: $bonusNumber" }
        return LotteryMachine.checkLotteriesWin(lotteries, winningNumbers, bonusNumber)
    }
}
