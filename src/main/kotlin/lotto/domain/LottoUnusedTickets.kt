package lotto.domain

data class LottoUnusedTickets(
    private val tickets: List<LottoUnusedTicket>
) {

    fun toAuto(count: Int): Pair<LottoUsedTickets, LottoUnusedTickets> {

        val autoTickets = tickets.take(count).map {
            ticket ->
            ticket.toAuto()
        }
        val rest = tickets.takeLast(tickets.size - count)
        return LottoUsedTickets(autoTickets) to LottoUnusedTickets(rest)
    }

    fun getTicketCount() = tickets.size

    companion object {
        fun from(count: Int): LottoUnusedTickets {
            return LottoUnusedTickets(
                (1..count).map { LottoUnusedTicket() }
            )
        }
    }
}
