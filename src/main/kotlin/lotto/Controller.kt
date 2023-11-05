package lotto

import lotto.app.LottoApp
import lotto.model.LottoWinners
import lotto.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val amount: Int = InputView.purchaseAmount(LottoApp.pricePerGame())
    val round = LottoApp.transaction(amount)
    OutputView.presetRound(round)
    val winningNumbers: WinningNumbers = InputView.drawing()
    val s: LottoWinners = round.winnerAggregate(winningNumbers)
    OutputView.presentPrizes(s)
}
