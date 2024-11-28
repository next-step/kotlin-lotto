package lotto.step4

import lotto.step4.domain.LottoGame
import lotto.step4.domain.LottoNumberPicker
import lotto.step4.domain.LottoPurchaseManager
import lotto.step4.view.InputView
import lotto.step4.view.OutputView

fun main() {
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
