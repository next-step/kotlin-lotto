package lotto.store

import lotto.ticket.IssuedLottoTickets
import lotto.ticket.LottoTicket

object LottoStore {
    private const val LOTTO_PRICE = 1000

    fun purchase(request: PurchaseRequest): IssuedLottoTickets {
        val issueCount = request.amount / LOTTO_PRICE

        val tickets = mutableListOf<LottoTicket>()
        repeat(issueCount.toInt()) {
            tickets.add(LottoTicket.ofAuto())
        }
        return IssuedLottoTickets(tickets)
    }
}
