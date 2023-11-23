package lotto2.application

import lotto2.domain.LottoFactory
import lotto2.domain.LottoGenerator
import lotto2.domain.LottoTicket

object LottoShop {
    const val LOTTO_PRICE = 1000

    fun buyLottoTickets(purchaseAmount: Int, lottoFactory: LottoFactory = LottoGenerator): List<LottoTicket> {
        val ticketQuantity = calculatePurchasableTickets(purchaseAmount)

        return List(ticketQuantity) { LottoTicket(lottoFactory.generate()) }
    }

    private fun calculatePurchasableTickets(purchaseAmount: Int) = purchaseAmount / LOTTO_PRICE
}
