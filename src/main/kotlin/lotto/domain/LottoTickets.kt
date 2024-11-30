package lotto.domain

class LottoTickets(private val tickets: List<Lotto>) {
    init {
        require(tickets.isNotEmpty()) { "At least one ticket is required." }
    }

    fun getTickets(): List<Lotto> = tickets

    fun size(): Int = tickets.size
}
