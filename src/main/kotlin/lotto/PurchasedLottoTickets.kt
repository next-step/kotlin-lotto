package lotto

data class PurchasedLottoTickets(val tickets: Collection<LottoTicket>, val pricePerTicket: Int) {

    infix fun lottoScore(ticket: LottoTicket): LottoScore {
        return tickets
            .map { it matchedCount ticket }
            .map(LottoRank::rankOf)
            .let { LottoScore(it, totalPrice) }
    }

    private val totalPrice: Int = tickets.size * pricePerTicket
}