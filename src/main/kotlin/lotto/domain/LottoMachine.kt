package lotto.domain

class LottoMachine(private val ticketPrice: Int) {

    init {
        require(ticketPrice > 0) { "티켓 가격은 양수여야 합니다." }
    }

    fun generateTickets(amount: Int): List<LottoTicket> {
        val ticketCount = amount / ticketPrice
        return List(ticketCount) { LottoTicket.generate() }
    }
}
