package lotto

import lotto.domain.Ticket

class TicketBuilder {
    companion object {
        fun sellTickets(count: Int): List<Ticket> {
            return (0 until count).map {
                create()
            }
        }

        private fun create(): Ticket {
            return Ticket(NUMBERS.shuffled().take(6))
        }

        private val NUMBERS = (1 until 45).toList()
    }
}
