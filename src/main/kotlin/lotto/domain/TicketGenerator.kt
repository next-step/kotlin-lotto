package lotto.domain

class TicketGenerator(private val numberStrategy: NumberStrategy) {


    private val TICKET_PRICE = 1000

    fun tickets(amount: Int): List<Ticket> {
        val count = amount / TICKET_PRICE
        return MutableList(count) {
            this.ticket()
        }
    }

    private fun ticket(): Ticket {
        val pickedNumbers = numberStrategy.numbers()
        return Ticket(pickedNumbers)
    }

}
