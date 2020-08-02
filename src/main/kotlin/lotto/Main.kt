import lotto.domain.LottoItems
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputMoney = InputView.inputMoney()
    val buyCount = InputView.getBuyCount(inputMoney)

    ResultView.printBuyCount(buyCount)

    val lottoItems = LottoItems(buyCount)
    val lottos = lottoItems.getLottoItems()

    val winningNumbers = InputView.inputWinningNumber()

    ResultView.printResult(lottos, lottoItems, winningNumbers)
}
