package lotto.domain

class LottoAnalytics {
    fun matchTickets(tickets: List<Ticket>, winningTicket: Ticket): LottoResult {
        return LottoResult().also { result ->
            tickets.forEach {
                result.countRank(it, winningTicket)
            }
        }
    }

    private fun Ticket.toRank(winningTicket: Ticket): Rank {
        return Rank.of(winningTicket.countMatches(this))
    }

    private fun LottoResult.countRank(ticket: Ticket, winningTicket: Ticket) {
        this[ticket.toRank(winningTicket)]++
    }
}
