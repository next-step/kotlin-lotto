import lotto.auto.domain.LotteryStore
import lotto.auto.infra.DefaultIOSystem
import lotto.auto.infra.RandomNumberGenerator
import lotto.auto.view.BuyResultView
import lotto.auto.view.InputLastWeekLottoView
import lotto.auto.view.InputMoneyView
import lotto.auto.view.LottoResultView

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
