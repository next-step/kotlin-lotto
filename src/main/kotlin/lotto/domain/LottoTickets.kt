package lotto.domain

class LottoTickets(
    val tickets: List<LottoTicket>
) : List<LottoTicket> by tickets
