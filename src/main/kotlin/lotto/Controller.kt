package lotto

import lotto.model.LottoWinners
import lotto.model.PurchaseGames
import lotto.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val amount: PurchaseGames = InputView.purchaseAmount(PurchaseGames.priceOfGame())
    val round = amount.transaction()
    OutputView.presetRound(round)
    val winningNumbers: WinningNumbers = InputView.selectWinningNumbers()
    val lottoWinners: LottoWinners = round.winnerAggregate(winningNumbers)
    OutputView.presentPrizes(lottoWinners)
}
