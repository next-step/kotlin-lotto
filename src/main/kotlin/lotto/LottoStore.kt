package lotto

data class LottoStore(val ticketStorage: LottoTicketStorage, val price: Int) {

    init {
        require(MIN_PRICE <= price) { "price must be greater than $MIN_PRICE. but provided price(`$price`)" }
    }

    infix fun purchasedLottoTickets(money: Int): PurchasedLottoTickets {
        return generateSequence { ticketStorage.lottoTicket }
            .take(money / price)
            .toList()
            .let { PurchasedLottoTickets(it, price) }
    }

    companion object {
        private const val MIN_PRICE = 1
    }
}