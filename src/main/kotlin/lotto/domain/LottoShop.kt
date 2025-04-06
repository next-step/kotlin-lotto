package lotto.domain

const val PRICE_FOR_ONT_TICKET = 1000

class LottoShop {
    fun purchase(purchaseAmount: Int): Tickets {
        val amountOfTicket = purchaseAmount / PRICE_FOR_ONT_TICKET
        return Tickets(amountOfTicket)
    }
}
