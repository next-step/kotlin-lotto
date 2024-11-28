package lotto.controller

import lotto.domain.DrawResult
import lotto.domain.LottoMachine
import lotto.domain.Money
import lotto.domain.TicketMachine
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = Money(InputView.inputPurchaseAmount())
    InputView.inputManualTicketCount()
    val tickets = TicketMachine.exchange(purchaseAmount)
    ResultView.printTicketCount(tickets)

    val purchaseLotteries = LottoMachine.autoPurchase(tickets)
    ResultView.printLotteries(purchaseLotteries)

    val winningLotto =
        WinningLotto.create(
            InputView.inputWinningLottoNumbers(),
            InputView.inputWinningBonusNumber(),
        )
    val drawResult = DrawResult.from(winningLotto, purchaseLotteries)
    ResultView.printStatistic(purchaseAmount, drawResult)
}
