import lotto.domain.LottoItems
import lotto.view.InputView
import lotto.view.ResultLotto
import lotto.view.ResultView

fun main() {
    val inputMoney = InputView.inputMoney()
    val buyCount = InputView.getBuyCount(inputMoney)

    ResultView.printBuyCount(buyCount)

    val lottoItems = LottoItems(buyCount)
    val lottos = lottoItems.getLottoItems()

    val winningNumbers = InputView.inputWinningNumber()

    ResultView.printResult(lottos, lottoItems, winningNumbers)
    val totalRate: Double = ResultLotto.totalIncome() / inputMoney.toDouble()
    println("총 수익률은 ${totalRate}입니다.")
}
