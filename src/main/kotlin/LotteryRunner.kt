import domain.Lottery
import domain.Settlement
import view.OutputView

object LotteryRunner {

    var lotteries = listOf<Lottery>()
        private set

    fun startLotto(
        money: Int,
        winningNums: Set<Int>,
        bonusBall: Int
    ) {
        val purchasableSize = purchaseLottery(money)
        val settlement = Settlement(winningNums)
        val returnOnInvestment = settlement.getReturnOnInvestment(lotteries, (purchasableSize * 1000), bonusBall)
        OutputView.reportProfit(returnOnInvestment)
    }

    private fun purchaseLottery(money: Int): Int {
        require(money > 1000) { "돈이 부족합니다." }

        val purchasableSize = money / 1000
        OutputView.reportPurchaseHistory(purchasableSize)
        lotteries = List(purchasableSize) { Lottery() }

        for (lottery in lotteries) {
            OutputView.reportPrizeState(lottery)
        }

        return purchasableSize
    }
}
