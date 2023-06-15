package lotto.model

data class LottoStore(val ticketStorage: LottoTicketStorage, val price: Long) {

    init {
        require(MIN_PRICE <= price) { "price must be greater than $MIN_PRICE. but provided price(`$price`)" }
    }

    infix fun purchaseLottoTicketsBy(money: Long): PurchasedLottoTickets {
        return generateSequence { ticketStorage.lottoTicket }
            .take((money / price).toInt())
            .toList()
            .let { PurchasedLottoTickets(it, price) }
    }

    companion object {
        private const val MIN_PRICE = 1
    }
}
