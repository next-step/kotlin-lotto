package lotto.domain.lotto.price

data class LottoTicketPrice(val price: Int = DEFAULT_LOTTO_TICKET_PRICE) {
    init {
        require(price > 0) { "Price must be greater than zero" }
    }

    companion object {
        const val DEFAULT_LOTTO_TICKET_PRICE = 1000
    }
}
