package lotto.step2

import lotto.step2.domain.LottoGame
import lotto.step2.domain.LottoNumberPicker
import lotto.step2.domain.LottoPurchaseManager

fun main() {
    val money = InputView.getPurchaseAmount()
    val lottos = LottoPurchaseManager(LottoNumberPicker()).purchase(money)
    OutputView.printPurchaseResult(lottos = lottos)

    val lastWeekWinningNumbers = InputView.getLastWeekWinningNumbers()
    val winningStatistics = LottoGame().execute(lastWeekWinningNumbers, lottos)
    OutputView.printStatistics(winningStatistics)
}
