package lotto

import lotto.app.LottoApp
import lotto.model.LottoStatistics
import lotto.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val amount: Int = InputView.purchaseAmount(LottoApp.priceOfGame())
    val transactionRound = LottoApp.transaction(amount)
    OutputView.presetRound(transactionRound)
    val winningNumbers: WinningNumbers = InputView.drawing()
    val s: LottoStatistics = transactionRound.winnerStatistics(winningNumbers)
    OutputView.presentPrizes(s)
}
