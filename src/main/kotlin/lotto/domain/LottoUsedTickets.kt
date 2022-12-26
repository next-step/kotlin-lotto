package lotto.domain

class LottoUsedTickets(
    private val tickets: List<LottoUsedTicket>
) {

    override fun toString(): String {
        return tickets.joinToString("\n")
    }

    operator fun plus(other: LottoUsedTickets): LottoUsedTickets {
        return LottoUsedTickets(tickets + other.tickets)
    }

    fun getSize() = tickets.size

    fun evaluate(winTicket: LottoWinTicket): LottoRewards {
        val rewards = tickets.map { ticket ->
            ticket.evaluate(winTicket)
        }
        return LottoRewards(rewards)
    }
}
