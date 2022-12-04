package lotto.domain

class LottoTickets(
    val ticketCategoryCount: TicketCategoryCount,
    val tickets: List<LottoTicket>
) : List<LottoTicket> by tickets
