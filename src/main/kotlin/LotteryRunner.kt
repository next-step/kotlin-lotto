import domain.Lottery
import view.InputView

class LotteryRunner(private val inputView: InputView) {

    var lotteries = listOf<Lottery>()
        private set

    fun startLotto() {
        val purchasableSize = inputView.buyLotto()
        lotteries = List(purchasableSize) { Lottery() }
    }
}
