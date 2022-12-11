package lotto.domain

class LottoUsedTickets(
    private val tickets: List<LottoUsedTicket>
) {

    fun evaluate(winTicket: LottoWinTicket): LottoRewards {
        val rewards = tickets.map { ticket ->
            ticket.evaluate(winTicket)
        }
        return LottoRewards(rewards)
    }

    override fun toString(): String {
        return tickets.joinToString("\n")
    }
}
