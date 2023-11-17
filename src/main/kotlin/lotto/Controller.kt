package lotto

import lotto.model.LottoWinners
import lotto.model.PurchaseGames
import lotto.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val totalPurchaseCount: Int = InputView.purchaseAmount(PurchaseGames.priceOfGame())
    val purchaseAmount = InputView.purchaseManual(totalPurchaseCount)
    val round = purchaseAmount.transaction()
    OutputView.presetRound(round)
    val winningNumbers: WinningNumbers = InputView.selectWinningNumbers()
    val lottoWinners: LottoWinners = round.winnerAggregate(winningNumbers)
    OutputView.presentPrizes(lottoWinners)
}
