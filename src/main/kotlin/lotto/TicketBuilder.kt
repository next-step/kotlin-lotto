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

        private fun randomNumbers(): List<Int> {
            return NUMBERS.shuffled().take(Ticket.TICKET_NUMBER_SIZE)
        }

        private val NUMBERS = (Ticket.TICKET_NUMBER_MIN until Ticket.TICKET_NUMBER_MAX).toList()
    }
}
