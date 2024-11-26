package lotto.step3

import lotto.step3.domain.LottoGame
import lotto.step3.domain.LottoNumberPicker
import lotto.step3.domain.LottoPurchaseManager
import lotto.step3.view.InputView
import lotto.step3.view.OutputView

class LottoApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val money = InputView.getPurchaseAmount()
            val lottos = LottoPurchaseManager(LottoNumberPicker()).purchase(money)
            OutputView.printPurchaseResult(lottos = lottos)

            val lastWeekWinningNumbers = InputView.getLastWeekWinningNumbers()
            val bonusNumber = InputView.getBonusNumber()
            val winningStatistics =
                LottoGame().execute(
                    lastWeekWinningNumbers = lastWeekWinningNumbers,
                    lottos = lottos,
                    bonusNumber = bonusNumber,
                )
            OutputView.printStatistics(winningStatistics)
        }
    }
}
