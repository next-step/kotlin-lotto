import lotto.domain.LottoItems
import lotto.view.InputView
import lotto.view.ResultLotto
import lotto.view.ResultView

fun main() {
    val inputMoney = InputView.inputMoney()
    val buyCount = InputView.getBuyCount(inputMoney)

    val lottoItems = LottoItems(buyCount)
    val lottos = lottoItems.getLottoItems()

    ResultView.printBuyCount(buyCount, lottos)

    val winningNumbers = InputView.inputWinningNumber()
    val result = lottoItems.getWinLottos(winningNumbers)

    ResultView.printResult(result)
    ResultView.printTotalRate(ResultLotto.totalRate(inputMoney))
}
