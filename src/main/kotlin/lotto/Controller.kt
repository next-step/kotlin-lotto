package lotto

import lotto.model.LottoOrder
import lotto.model.LottoTicket
import lotto.model.LottoWinners
import lotto.model.WinningNumbers
import lotto.model.issue.LottoIssueMachineAuto
import lotto.model.issue.LottoIssueMachineManual
import lotto.model.strategy.LottoNumberRandomStrategy
import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    val totalPurchaseCount: Int = InputView.purchaseAmount(LottoOrder.priceOfGame())
    val order: LottoOrder = InputView.purchaseManual(totalPurchaseCount)

    val manualTicket: LottoTicket = LottoIssueMachineAuto(LottoNumberRandomStrategy).buy(order)
    val autoTicket: LottoTicket = LottoIssueMachineManual.buy(order)
    OutputView.presentPurchaseInfo(manualTicket, autoTicket)
    val totalTicket: LottoTicket = autoTicket + manualTicket
    OutputView.presetRound(totalTicket)

    val winningNumbers: WinningNumbers = InputView.selectWinningNumbers()
    val lottoWinners: LottoWinners = totalTicket.winnerAggregate(winningNumbers)
    OutputView.presentPrizes(lottoWinners)
}
