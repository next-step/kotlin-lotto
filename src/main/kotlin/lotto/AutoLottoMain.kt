package lotto

import lotto.ui.InputView
import lotto.ui.ResultView
import lotto.vo.WinningLotto

fun main() {
    while (true) {
        try {
            val price = InputView.promptForPrice()
            val count = InputView.promptForManualLottoCount()
            val manualLottoStrings = InputView.promptForManualLottoStrings(count)
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
