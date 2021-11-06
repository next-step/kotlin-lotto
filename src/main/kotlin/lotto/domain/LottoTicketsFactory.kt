package lotto.domain

object LottoTicketsFactory {

    fun create(count: LottoTicketCount): LottoTickets {
        val tickets = mutableListOf<LottoNumbers>()
        while (count.isTicketRemain()) {
            val newTicket = LottoGenerator.randomTicket()
            tickets.add(newTicket)
            count.useTicket()
        }
        return LottoTickets(tickets)
    }
}
