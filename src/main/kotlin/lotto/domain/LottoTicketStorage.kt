package lotto.domain

class LottoTicketStorage (
    private val lottoTickets: MutableList<LottoTicket> = mutableListOf()
) {
    fun save(tickets: List<LottoTicket>): List<LottoTicket> {
        lottoTickets += tickets
        return getAll()
    }

    fun getAll(): List<LottoTicket> = lottoTickets.toList()
}
