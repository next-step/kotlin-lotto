package lotto.controller

import lotto.model.LottoResult
import lotto.model.PurchasedTickets
import lotto.model.RandomTicketNumberGenerator
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {

    companion object {
        private val generator = RandomTicketNumberGenerator()
        fun run() {
            val purchasedAmount = InputView.readPurchaseAmount()
            val purchasedTickets = PurchasedTickets.buyTickets(purchasedAmount, generator)
            ResultView.showTickets(purchasedTickets.getTickets())

            val winningNumbers = InputView.readWinningNumbers()
            val result = LottoResult(winningNumbers, purchasedTickets.getTickets())
            ResultView.showStatistics(result, purchasedAmount)
        }
    }
}