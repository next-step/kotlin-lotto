import lotto.domain.LotteryStore
import lotto.infra.DefaultIOSystem
import lotto.infra.RandomNumberGenerator
import lotto.view.BuyResultView
import lotto.view.InputLastWeekLottoView
import lotto.view.InputMoneyView
import lotto.view.LottoResultView

fun main() {
    val ioSystem = DefaultIOSystem()
    val randomNumberGenerator = RandomNumberGenerator(1, 45)
    val lotteryStore = LotteryStore(randomNumberGenerator)

    val inputMoneyView = InputMoneyView(ioSystem)

    val amount = inputMoneyView.getMoney()
    val lotteries = lotteryStore.sell(amount)
    val buyResultView = BuyResultView(ioSystem, lotteries)
    buyResultView.printLottos()

    val lastWeekLottoView = InputLastWeekLottoView(ioSystem)
    val winningLottery = lastWeekLottoView.getLastWeekLotto()
    val lottoResultView = LottoResultView(ioSystem)
    lottoResultView.printResult(lotteries, winningLottery)
}
