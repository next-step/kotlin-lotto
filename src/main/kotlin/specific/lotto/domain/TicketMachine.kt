package specific.lotto.domain

class TicketMachine {
    fun sellTickets(money: Money): Tickets {
        val count = money.remaining / Ticket.PRICE
        require(count <= Int.MAX_VALUE) { "cannot purchase more than ${Int.MAX_VALUE}" }
        val tickets: Tickets = List(count.toInt()) { issueTicket() }
        money.spend(Ticket.PRICE * count)
        return tickets
    }

    private fun issueTicket(
        numbers: Set<Number> = Number.getNumberPool().shuffled().take(Ticket.NUMBERS_SIZE).toSet(),
    ) = Ticket(numbers)

}
