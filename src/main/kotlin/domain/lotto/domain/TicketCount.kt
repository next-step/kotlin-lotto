package domain.lotto.domain

import domain.lotto.error.InvalidTicketCountRangeException

@JvmInline
value class TicketCount(val ticketCount: Int) {
    init {
        validateTicketCountRange(ticketCount)
    }

    fun subtract(other: TicketCount): TicketCount = TicketCount(Math.subtractExact(ticketCount, other.ticketCount))

    private fun validateTicketCountRange(ticketCount: Int) {
        if (ticketCount < MINIMUM) {
            throw InvalidTicketCountRangeException(ticketCount)
        }
    }

    companion object {
        const val MINIMUM = 0
    }
}


