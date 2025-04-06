package lotto.domain

class Tickets(val tickets: List<Ticket>) {
    constructor(amountOfTicket: Int) : this(generateTickets(amountOfTicket))

    companion object {
        private fun generateTickets(amountOfTicket: Int): List<Ticket> {
            return List(amountOfTicket) { Ticket() }
        }
    }

    fun size() : Int {
        return tickets.size
    }
}
