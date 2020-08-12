package lotto.domain

class LottoTickets(
    val tickets: List<LottoTicket>
) {
    operator fun plus(other: LottoTickets): LottoTickets {
        return LottoTickets(this.tickets + other.tickets)
    }

    fun size() = tickets.size

    override fun toString(): String {
        return tickets.joinToString("\n")
    }
}
