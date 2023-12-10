package lotto

import lotto.ui.InputView
import lotto.ui.ResultView
import lotto.domain.Lottos
import lotto.domain.WinningLotto

fun main() {
    while (true) {
        try {
            val budget = InputView.promptForPrice()
            val manualLottoCount = InputView.promptForManualLottoCount(budget)
            val manualLottos = InputView.promptForManualLotto(manualLottoCount)
            val autoLottoBuyPrice = ResultView.promptForBuyCount(manualLottoCount, budget)
            ResultView.promptForManualLotto(manualLottos)
            val autoLotto = ResultView.promptForAutoLotto(autoLottoBuyPrice)
            val lottos = Lottos(manualLottos.lottos + autoLotto.lottos)

            val lastWeekWinningNumbers = InputView.promptForLastWeekWinningNumbers()
            val lastWeekBonusNumber = InputView.promptForBonusNumbers()
            val winningLotto = WinningLotto(lastWeekWinningNumbers, lastWeekBonusNumber)
            ResultView.printWinningPoints(budget, lottos, winningLotto)
            break
        } catch (e: Exception) {
            println(e.message)
        }
    }
}
