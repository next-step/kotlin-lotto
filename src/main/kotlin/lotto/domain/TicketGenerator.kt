package lotto.domain

class TicketGenerator(private val numberStrategy: NumberStrategy) {

    fun tickets(amount: Int, manualTickets: Tickets? = Tickets(emptyList())): Tickets {

        val count = (amount / TICKET_PRICE) - manualTickets?.tickets?.size!!
        val tickets = Tickets(MutableList(count) {
            this.ticket()
        } + manualTickets.tickets)

        return tickets
    }

    private fun ticket(): Ticket {
        return Ticket(numberStrategy.numbers())
    }

    companion object {
        private val TICKET_PRICE = 1000
    }

}
