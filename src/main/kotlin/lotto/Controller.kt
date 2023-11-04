package lotto

import lotto.app.Lotto
import lotto.model.LottoStatistics
import lotto.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lotto:Lotto = Lotto()
    val amount:Int = InputView.purchaseAmount(lotto.priceOfGame())
    val transactionRound = lotto.transaction(amount)
    OutputView.presetRound(transactionRound)
    val winningNumbers : WinningNumbers= InputView.drawing()
    val s : LottoStatistics = transactionRound.winnerStatistics(winningNumbers)
    OutputView.presentPrizes(s)
}
