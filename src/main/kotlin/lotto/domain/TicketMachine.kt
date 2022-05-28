package lotto.domain

class TicketMachine {

    fun buy(amount: Int): List<LottoTicket> {
        val tickets = mutableListOf<LottoTicket>()
        repeat(amount / TICKET_PRICE) { tickets += LottoTicket(listOf(1, 2, 3, 4, 5, 6)) }
        return tickets
    }

    companion object {
        private const val TICKET_PRICE = 1_000
    }
}
