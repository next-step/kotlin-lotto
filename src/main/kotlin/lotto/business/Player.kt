package lotto.business

class Player(tickets: List<LottoTicket> = listOf(), purchasableCount: Int) {
    private var _tickets = tickets.toMutableList()
    private var _purchasableCount = purchasableCount

    val tickets: List<LottoTicket>
        get() = _tickets.toList()

    val purchasableCount: Int
        get() = _purchasableCount

    fun addTicket(ticket: LottoTicket) {
        _tickets.add(ticket)
        _purchasableCount -= 1
    }

    fun addTickets(manualTickets: List<LottoTicket>) {
        _tickets.addAll(manualTickets)
        _purchasableCount -= manualTickets.size
    }
}
