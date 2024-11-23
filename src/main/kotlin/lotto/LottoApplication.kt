package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoNumberPicker
import lotto.domain.LottoPurchaseManager
import lotto.view.InputView
import lotto.view.OutputView

class LottoApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val money = InputView.getPurchaseAmount()
            val lottos = LottoPurchaseManager(LottoNumberPicker()).purchase(money)
            OutputView.printPurchaseResult(lottos = lottos)

            val lastWeekWinningNumbers = InputView.getLastWeekWinningNumbers()
            val winningStatistics = LottoGame().execute(lastWeekWinningNumbers, lottos)
            OutputView.printStatistics(winningStatistics)
        }
    }
}
