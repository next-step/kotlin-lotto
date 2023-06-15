import domain.Lottery
import view.InputView

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
        var totalPrize = 0
        for (lottery in lotteries) {
            val matchedCount = lottery.countMatchingLottery(winningNums)
            totalPrize += when (matchedCount) {
                3 -> 5000
                4 -> 50000
                5 -> 1500000
                6 -> 2000000000
                else -> 0
            }
        }

        val returnOnInvestment = totalPrize / (purchasableSize * 1000)
        val message = if (returnOnInvestment > 1) {
            "이익을 얻었습니다."
        } else {
            "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        }
        println("총 수익률은 ${returnOnInvestment}입니다.$message")
    }
}
