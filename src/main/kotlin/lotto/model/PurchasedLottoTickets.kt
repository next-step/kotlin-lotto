package lotto.model

data class PurchasedLottoTickets(val tickets: Collection<LottoTicket>, val pricePerTicket: Long) {

    infix fun lottoScore(ticket: LottoTicket): LottoScore {
        return tickets
            .map { it matchedCount ticket }
            .map(LottoRank.Companion::rankOf)
            .let { LottoScore(it, totalPrice) }
    }

    private val totalPrice: Long = tickets.size * pricePerTicket
}