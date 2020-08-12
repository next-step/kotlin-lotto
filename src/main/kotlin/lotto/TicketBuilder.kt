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
            return Ticket(randomNumbers())
        }

        private fun randomNumbers(): Set<Int> {
            return NUMBERS.shuffled().take(Ticket.TICKET_NUMBER_SIZE).toSet()
        }

        private val NUMBERS = (Ticket.TICKET_NUMBER_MIN until Ticket.TICKET_NUMBER_MAX).toList()
    }
}
