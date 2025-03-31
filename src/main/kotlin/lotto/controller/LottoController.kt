package lotto.controller

import lotto.model.LottoResult
import lotto.model.PurchasedTickets
import lotto.model.RandomTicketNumberGenerator

class LottoController {

    companion object {
        private val generator = RandomTicketNumberGenerator()
        fun run() {
            val purchasedAmount = 5000
            val purchasedTickets = PurchasedTickets.buyTickets(purchasedAmount, generator)
            println(purchasedTickets.getTickets())
            val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val result = LottoResult(winningNumbers, purchasedTickets.getTickets())
            println(result)
        }
    }
}