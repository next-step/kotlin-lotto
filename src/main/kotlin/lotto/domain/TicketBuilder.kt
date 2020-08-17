package lotto.domain

class TicketBuilder {
    companion object {
        fun sellTickets(count: Int): List<Ticket> {
            return (0 until count).map {
                create()
            }
        }

        fun sellTicketsManually(texts: List<String>): List<Ticket> {
            return texts.map { create(it) }
        }

        fun howMuchTickets(money: Int): Int {
            return money / TICKET_COST
        }

        private fun create(): Ticket {
            return Ticket(randomNumbers())
        }

        private fun create(it: String) = Ticket(toIntSet(it))

        private fun toIntSet(it: String) = it.split(",").map { it.trim().toInt() }.toSet()

        private fun randomNumbers(): Set<Int> {
            return NUMBERS.shuffled().take(Ticket.TICKET_NUMBER_SIZE).toSet()
        }

        const val TICKET_COST = 1000
        private val NUMBERS = (Ticket.TICKET_NUMBER_MIN until Ticket.TICKET_NUMBER_MAX).toList()
    }
}
