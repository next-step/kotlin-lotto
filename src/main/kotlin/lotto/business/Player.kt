package lotto.business

class Player(tickets: List<LottoTicket> = listOf(), val purchasedCount: Int) {
    private var _tickets = tickets.toMutableList()

    val purchasableCount: Int
        get() = purchasedCount - tickets.size

    val tickets: List<LottoTicket>
        get() = _tickets.toList()

    init {
        require(purchasedCount >= 1) { throw IllegalArgumentException("구매 가능한 로또 개수는 1개 이상이어야 합니다.") }
    }

    fun addTicket(ticket: LottoTicket) {
        require(purchasableCount >= 1) { throw IllegalArgumentException("더 이상 로또를 구매할 수 없습니다.") }
        _tickets.add(ticket)
    }

    fun addTickets(manualTickets: List<LottoTicket>) {
        require(purchasableCount >= manualTickets.size) { throw IllegalArgumentException("더 이상 로또를 구매할 수 없습니다.") }
        _tickets.addAll(manualTickets)
    }
}
