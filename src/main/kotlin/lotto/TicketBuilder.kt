package lotto

import lotto.domain.Ticket

class TicketBuilder {
    companion object {
        fun sellTickets(money: Int): List<Ticket> {
            return createTickets(howMuchTickets(money))
        }

        private fun createTickets(count: Int): List<Ticket> {
            return (0 until count).map {
                create()
            }
        }

        private fun howMuchTickets(money: Int): Int {
            return money / TICKET_COST
        }

        private fun create(): Ticket {
            return Ticket(randomNumbers())
        }

        private fun randomNumbers(): Set<Int> {
            return NUMBERS.shuffled().take(Ticket.TICKET_NUMBER_SIZE).toSet()
        }

        const val TICKET_COST = 1000
        private val NUMBERS = (Ticket.TICKET_NUMBER_MIN until Ticket.TICKET_NUMBER_MAX).toList()
    }
}
