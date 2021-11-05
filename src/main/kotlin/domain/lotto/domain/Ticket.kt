package domain.lotto.domain

import domain.lotto.error.InvalidTicketCountRangeException

class Ticket(private val ticketCount: Int) {
    init {
        validateTicketCountRange(ticketCount)
    }

    private fun validateTicketCountRange(ticketCount: Int) {
        if (ticketCount < 0) {
            throw InvalidTicketCountRangeException(ticketCount)
        }
    }
}
