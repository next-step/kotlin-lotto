
import lotto.LottoGame
import lotto.io.InputView
import lotto.io.ResultView

fun main() {
    val purchaseAmount = InputView.getAmount()
    val lottoGame = LottoGame(purchaseAmount)
    val winNumbers = InputView.getWinNumbers()
    val result = lottoGame.getResult(winNumbers)
    ResultView.printResult(result, purchaseAmount)
}
