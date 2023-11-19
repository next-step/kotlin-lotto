package lotto2.application

import lotto2.domain.LottoFactory
import lotto2.domain.LottoGenerator
import lotto2.domain.LottoTicket
import lotto2.domain.LottoTickets

object LottoShop {
    const val LOTTO_PRICE = 1000

    fun buyLottoTickets(purchaseAmount: Int, lottoFactory: LottoFactory = LottoGenerator): LottoTickets {
        val ticketQuantity = calculatePurchasableTickets(purchaseAmount)
        val lottoTickets = List(ticketQuantity) { LottoTicket(lottoFactory.generate()) }

        return LottoTickets(lottoTickets)
    }

    private fun calculatePurchasableTickets(purchaseAmount: Int) = purchaseAmount / LOTTO_PRICE
}
