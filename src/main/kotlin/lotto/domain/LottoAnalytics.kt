package lotto.domain

class LottoAnalytics {
    companion object {
        fun matchTickets(tickets: List<Ticket>, winningTicket: WinningTicket): LottoResult {
            return LottoResult().also { result ->
                tickets.forEach {
                    result.countRank(it, winningTicket)
                }
            }
        }

        private fun Ticket.toRank(winningTicket: WinningTicket): Rank {
            return Rank.of(
                winningTicket.ticket.countMatches(this),
                winningTicket.bonusNumber.match(this)
            )
        }

        private fun LottoResult.countRank(ticket: Ticket, winningTicket: WinningTicket) {
            this[ticket.toRank(winningTicket)]++
        }
    }
}
