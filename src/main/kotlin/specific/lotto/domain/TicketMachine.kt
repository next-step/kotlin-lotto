package specific.lotto.domain

class TicketMachine {
    fun sellTickets(money: Money): List<Ticket> {
        val count = money.remain / Ticket.PRICE
        require(count <= Int.MAX_VALUE) { "cannot purchase more than ${Int.MAX_VALUE}" }
        val tickets = List(count.toInt()) { issueTicket() }
        money.spend(Ticket.PRICE * count)
        return tickets
    }

    private fun issueTicket(
        numbers: Set<Number> = Number.getNumberPool().shuffled().take(Ticket.NUMBERS_SIZE).toSet(),
    ) = Ticket(numbers)

}
