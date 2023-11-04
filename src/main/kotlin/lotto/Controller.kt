package lotto

import lotto.app.LottoApp
import lotto.model.LottoStatistics
import lotto.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val amount: Int = InputView.purchaseAmount(LottoApp.priceOfGame())
    val round = LottoApp.transaction(amount)
    OutputView.presetRound(round)
    val winningNumbers: WinningNumbers = InputView.drawing()
    val s: LottoStatistics = round.winnerStatistics(winningNumbers)
    OutputView.presentPrizes(s)
}
