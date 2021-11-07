package lotto.domain

object LottoTicketsFactory {

    @Suppress("NAME_SHADOWING")
    fun create(count: LottoTicketCount): LottoTickets {
        var count = count
        val tickets = mutableListOf<LottoNumbers>()
        while (count.isTicketRemain()) {
            val newTicket = LottoGenerator.randomTicket()
            tickets.add(newTicket)
            count = count.useTicket()
        }
        return LottoTickets(tickets)
    }
}
