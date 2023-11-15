package lotto.business

class Player(tickets: List<LottoTicket> = listOf(), val receivedAmount: ReceivedAmount) {
    private var _tickets = tickets.toMutableList()

    val purchasedCount: Int
        get() = receivedAmount.getTicketCount()

    val purchasableCount: Int
        get() = purchasedCount - tickets.size

    val tickets: List<LottoTicket>
        get() = _tickets.toList()

    fun addTicket(ticket: LottoTicket) {
        require(purchasableCount >= 1) { throw IllegalArgumentException("더 이상 로또를 구매할 수 없습니다.") }
        _tickets.add(ticket)
    }

    fun addTickets(tickets: List<LottoTicket>) {
        require(purchasableCount >= tickets.size) { throw IllegalArgumentException("더 이상 로또를 구매할 수 없습니다.") }
        _tickets.addAll(tickets)
    }
}
