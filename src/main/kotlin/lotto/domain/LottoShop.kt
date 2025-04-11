package lotto.domain


class LottoShop {
    companion object {
        const val PRICE_FOR_ONT_TICKET = 1000
    }

    fun purchase(purchaseAmount: Int, manualTickets: List<Ticket>): Tickets {
        val numberOfRandomTickets = (purchaseAmount / PRICE_FOR_ONT_TICKET) - manualTickets.size
        return Tickets(numberOfRandomTickets, manualTickets)
    }
}
