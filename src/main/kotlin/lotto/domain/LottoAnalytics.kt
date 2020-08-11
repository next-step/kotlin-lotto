package lotto.domain

class LottoAnalytics {
    fun matchTickets(tickets: List<Ticket>, winner: Ticket): LottoResult {
        return LottoResult().also { result ->
            tickets.forEach {
                result.countRank(it, winner)
            }
        }
    }

    private fun Ticket.toRank(winner: Ticket): Rank {
        return Rank.of(winner.countMatches(this))
    }

    private fun LottoResult.countRank(ticket: Ticket, winner: Ticket) {
        this[ticket.toRank(winner)]++
    }
}
