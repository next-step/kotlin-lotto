package lotto.model

data class PurchasedLottoTickets(val tickets: Collection<LottoTicket>, val pricePerTicket: Long) {

    infix fun scoreBy(winnerLottoTicket: WinnerLottoTicket): LottoScore {
        return tickets.map {
            LottoRank.rankOf(
                it matchedCountBy winnerLottoTicket.lottoTicket,
                it has winnerLottoTicket.bonusNumber
            )
        }.let { LottoScore(it, totalPrice) }
    }

    private val totalPrice: Long = tickets.size * pricePerTicket
}
