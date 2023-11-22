import lotto.domain.Lotteries
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.askMoney()

    val lotteries = Lotteries.of(money)

    InputView.print(lotteries)

    val winningNumber = InputView.askWinningNumbers()

    val winningResult = lotteries.winningResult(winningNumber)

    ResultView.print(winningResult, money)
}
