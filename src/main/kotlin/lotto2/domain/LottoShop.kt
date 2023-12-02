package lotto2.domain

object LottoShop {
    const val LOTTO_PRICE = 1_000

    fun buyManualTicket(
        purchaseAmount: LottoMoney,
        manualTicketNumbers: List<LottoNumbers>
    ): List<LottoTicket> {
        purchaseAmount.subtract(manualTicketNumbers.size * LOTTO_PRICE)

        return LottoFactory.generate(manualTicketNumbers)
    }

    fun buyAutoTickets(
        purchaseAmount: LottoMoney,
        ticketQuantity: Int
    ): List<LottoTicket> {
        purchaseAmount.subtract(ticketQuantity * LOTTO_PRICE)

        return LottoFactory.generate(ticketQuantity)
    }
}
