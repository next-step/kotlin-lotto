package autolotto

import autolotto.ui.InputView
import autolotto.ui.ResultView
import autolotto.vo.WinningLotto

fun main() {
    while (true) {
        try {
            val price = InputView.promptForPrice()
            val autoLotto = ResultView.promptForAutoLotto(price)

            val lastWeekWinningNumbers = InputView.promptForLastWeekWinningNumbers()
            val lastWeekBonusNumber = InputView.promptForBonusNumbers()
            val winningLotto = WinningLotto(lastWeekWinningNumbers, lastWeekBonusNumber)
            ResultView.printWinningPoints(autoLotto, winningLotto)
            break
        } catch (e: Exception) {
            println(e.message)
        }
    }
}
