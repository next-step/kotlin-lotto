package lotto.controller

import lotto.model.LottoResult
import lotto.model.PurchasedTickets
import lotto.model.RandomTicketNumberGenerator
import lotto.view.InputView

class LottoController {

    companion object {
        private val generator = RandomTicketNumberGenerator()
        fun run() {
            val purchasedAmount = InputView.readPurchaseAmount()
            val purchasedTickets = PurchasedTickets.buyTickets(purchasedAmount, generator)
            println(purchasedTickets.getTickets())
            val winningNumbers = InputView.readWinningNumbers()
            val result = LottoResult(winningNumbers, purchasedTickets.getTickets())
            println(result)
        }
    }
}