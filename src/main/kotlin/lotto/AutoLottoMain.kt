package lotto

import lotto.ui.InputView
import lotto.ui.ResultView
import lotto.vo.Lottos
import lotto.vo.WinningLotto

fun main() {
    while (true) {
        try {
            val price = InputView.promptForPrice()
            val manualLottoCount = InputView.promptForManualLottoCount()
            val manualLottos = InputView.promptForManualLotto(manualLottoCount)
            val autoLottoBuyPrice = ResultView.promptForBuyCount(manualLottoCount, price)
            ResultView.promptForManualLotto(manualLottos)
            val autoLotto = ResultView.promptForAutoLotto(autoLottoBuyPrice)
            val lottos = Lottos(price, manualLottos.lottos + autoLotto.lottos)

            val lastWeekWinningNumbers = InputView.promptForLastWeekWinningNumbers()
            val lastWeekBonusNumber = InputView.promptForBonusNumbers()
            val winningLotto = WinningLotto(lastWeekWinningNumbers, lastWeekBonusNumber)
            ResultView.printWinningPoints(lottos, winningLotto)
            break
        } catch (e: Exception) {
            println(e.message)
        }
    }
}
