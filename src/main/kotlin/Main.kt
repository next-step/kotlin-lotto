import lotto.domain.LotteryStore
import lotto.infra.DefaultIOSystem
import lotto.infra.LottoNumberGenerator
import lotto.view.BuyResultView
import lotto.view.InputLastWeekLottoView
import lotto.view.InputMoneyView
import lotto.view.LottoResultView

fun main() {
    val ioSystem = DefaultIOSystem()
    val lottoNumberGenerator = LottoNumberGenerator()
    val lotteryStore = LotteryStore(lottoNumberGenerator)

    val inputMoneyView = InputMoneyView(ioSystem)

    val amount = inputMoneyView.getMoney()
    val lotteries = lotteryStore.sell(amount)
    val buyResultView = BuyResultView(ioSystem)
    buyResultView.printLotteries(lotteries)

    val lastWeekLottoView = InputLastWeekLottoView(ioSystem)
    val winningLottery = lastWeekLottoView.getLastWeekLotto()
    val lottoResultView = LottoResultView(ioSystem)
    lottoResultView.printResult(lotteries, winningLottery)
}
