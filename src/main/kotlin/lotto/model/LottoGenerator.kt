package lotto.model

class LottoGenerator {

    companion object {
        fun generateTickets(count: Int, ticketLength: Int, ticketRange: IntRange) = List(count) { Ticket(ticketLength, ticketRange) }
    }
}
