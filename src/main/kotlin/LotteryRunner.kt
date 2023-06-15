import domain.Lottery
import domain.Settlement
import view.InputView
import view.OutputView

class LotteryRunner(private val inputView: InputView) {

    var lotteries = listOf<Lottery>()
        private set

    fun startLotto() {
        val purchasableSize = inputView.buyLotto()
        lotteries = List(purchasableSize) { Lottery() }
        for (lottery in lotteries) {
            println(lottery.randomNumber.toString())
        }

        val winningNums = inputView.registerWinningNums()
        val settlement = Settlement(winningNums)
        val returnOnInvestment = settlement.getReturnOnInvestment(lotteries, (purchasableSize * 1000))

        OutputView.reportProfit(returnOnInvestment)
    }
}
