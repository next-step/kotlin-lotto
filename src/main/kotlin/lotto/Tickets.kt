package lotto

@JvmInline
value class Tickets(private val tickets: List<Ticket>) {
    fun count() = tickets.size

    companion object {
        fun from(money: Money): Tickets {
            TODO()
        }
    }
}
