import domain.Lottery
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
        val outputView = OutputView(winningNums)
        val profit = outputView.calculateProfit(lotteries)

        val returnOnInvestment = profit.toDouble() / (purchasableSize * 1000)
        outputView.reportProfit(returnOnInvestment)
    }
}
