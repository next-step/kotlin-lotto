package autolotto

import autolotto.ui.InputView
import autolotto.ui.ResultView
import autolotto.vo.AutoLotto
import autolotto.vo.WinningLotto

fun main() {
    while (true) {
        try {
            val price = InputView.promptForPrice()
            val autoLotto = AutoLotto(price)
            println("로또 ${autoLotto.count}개를 구매했습니다.")
            autoLotto.lottos.forEach { lotto ->
                println(lotto.numbers)
            }

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
