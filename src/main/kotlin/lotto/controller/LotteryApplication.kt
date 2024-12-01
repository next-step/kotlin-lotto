package lotto.controller

import lotto.domain.DrawResult
import lotto.domain.LottoMachine
import lotto.domain.LottoNumbers
import lotto.domain.Money
import lotto.domain.TicketMachine
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = Money(InputView.inputPurchaseAmount())

    val manualTicketCount = InputView.inputManualTicketCount()
    val manualLottoNumbersList = InputView.inputManualLottoNumbersList(manualTicketCount).map { LottoNumbers.from(it) }

    val tickets = TicketMachine.exchange(purchaseAmount, manualLottoNumbersList)
    ResultView.printTicketCount(tickets)

    val purchaseLotteries = LottoMachine.purchase(tickets)
    ResultView.printLotteries(purchaseLotteries)

    val winningLotto =
        WinningLotto.create(
            lottoNumbers = LottoNumbers.from(InputView.inputWinningLottoNumbers()),
            bonus = InputView.inputWinningBonusNumber(),
        )
    val drawResult = DrawResult.from(winningLotto, purchaseLotteries)
    ResultView.printStatistic(purchaseAmount, drawResult)
}
