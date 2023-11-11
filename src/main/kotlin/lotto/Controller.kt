package lotto

import lotto.model.Issuer
import lotto.model.LottoWinners
import lotto.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val amount: Int = InputView.purchaseAmount(Issuer.pricePerGame())
    val round = Issuer.transaction(amount)
    OutputView.presetRound(round)
    val winningNumbers: WinningNumbers = InputView.drawing()
    val lottoWinners: LottoWinners = round.winnerAggregate(winningNumbers)
    OutputView.presentPrizes(lottoWinners)
}
