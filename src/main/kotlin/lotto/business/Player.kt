package lotto.business

class Player(tickets: List<LottoTicket> = listOf()) {
    private var _tickets = tickets.toMutableList()

    val tickets: List<LottoTicket>
        get() = _tickets.toList()

    fun addTickets(tickets: List<LottoTicket>) {
        _tickets.addAll(tickets)
    }
}
