package lotto.domain


class LottoShop {
    companion object {
        const val PRICE_FOR_ONT_TICKET = 1000
    }

    fun purchase(purchaseAmount: Int): Tickets {
        val amountOfTicket = purchaseAmount / PRICE_FOR_ONT_TICKET
        return Tickets(amountOfTicket)
    }
}
