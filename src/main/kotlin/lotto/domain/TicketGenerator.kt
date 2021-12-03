package lotto.domain

class TicketGenerator(private val numberStrategy: NumberStrategy) {

    private val TICKET_PRICE = 1000

    fun tickets(amount: Int): Tickets {
        val count = amount / TICKET_PRICE
        return Tickets(MutableList(count) {
            this.ticket()
        })
    }

    private fun ticket(): Ticket {
        return Ticket(numberStrategy.numbers())
    }

}
