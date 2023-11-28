package lotto

import lotto.model.LottoWinners
import lotto.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView
import lotto.view.order.LottoOrder

fun main() {
    val order = LottoOrder(
        totalAmount = InputView.amountLottoOrder(),
        manualCount = InputView.manualOrderCount()
    )
    val ticket = order.ticketing()

    OutputView.presentTicket(ticket)

    val winningNumbers: WinningNumbers = InputView.selectWinningNumbers()

    val lottoWinners: LottoWinners = ticket.winnerAggregate(winningNumbers)
    OutputView.presentPrizes(lottoWinners, order.pricePerGame())
}
