package domain.lotto.domain

import domain.lotto.error.InvalidTicketCountRangeException

@JvmInline
value class Ticket(val ticketCount: Int) {
    init {
        validateTicketCountRange(ticketCount)
    }

    operator fun minus(other: Ticket): Ticket {
        return Ticket(Math.subtractExact(ticketCount, other.ticketCount))
    }

    private fun validateTicketCountRange(ticketCount: Int) {
        if (ticketCount < MINIMUM) {
            throw InvalidTicketCountRangeException(ticketCount)
        }
    }

    companion object {
        private const val MINIMUM = 0
    }
}


