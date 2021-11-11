package lotto

private const val TICKET_PRICE = 1000

@JvmInline
value class Tickets(private val tickets: List<Ticket>) {
    fun count() = tickets.size

    companion object {
        fun from(money: Money): Tickets {
            val count = money.value / TICKET_PRICE
            return Tickets((1..count).map { Ticket.random() })
        }
    }
}
