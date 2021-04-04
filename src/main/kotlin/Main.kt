import domain.lotto.Lottos
import domain.money.Money
import domain.winning.WinningStatistics
import domain.store.LottoStore
import view.buyinginput.BuyingInputView
import view.BuyingResultView
import view.manualpick.ManualPickInputView
import view.WinningNumbersInputView
import view.WinningStatisticsView

fun main() {
    val store = LottoStore(price = Money(1000))

    val buyingInput = BuyingInputView.receiveAmount()
    ManualPickInputView.receiveManualPick()

    val lottos = Lottos(store.buyLottos(buyingInput.toMoney()))
    BuyingResultView.print(lottos)

    val winningNumbersInput = WinningNumbersInputView.receiveWinningNumbers()
    val statistics = WinningStatistics(winningNumbersInput.toWinningNumbers(), lottos)
    WinningStatisticsView.print(statistics, lottos, store.price)
}
