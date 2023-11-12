import lotto.view.InputType
import lotto.view.InputView
import lotto.view.ResultType
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val lottoGame = LottoGame()

    val amount = inputView.inputPrice(InputType.PURCHASE_AMOUNT)
    val count = LottoGame().getLottoCount(amount)

    resultView.printCount(ResultType.PURCHASE_COUNT, count)

    val lottoList = lottoGame.start(count)

    val lastNumbers = inputView.inputNumbers(InputType.LAST_WEEK_WINNING_NUMBER)

    lottoGame.result(lottoList, lastNumbers)
    resultView.printResult(amount, lottoList)
}
