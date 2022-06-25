package lotto.entity

class MatcherImpl(private val winningNumbers: List<Int>, private val bonusNumber: Int) : Matcher {
    override fun matchOneTicket(ticket: LottoTicket): Rank {
        val matches = ticket.numbers.intersect(this.winningNumbers.toSet()).count()
        if (matches == 5) {
            if (ticket.numbers.contains(bonusNumber)) return Rank.SECOND
            return Rank.THIRD
        }
        return Rank.find(matches)
    }

    override fun matchAllTickets(tickets: List<LottoTicket>): List<Rank> {
        return tickets.map { ticket -> matchOneTicket(ticket) }
    }

    override fun countTicketRanks(tickets: List<LottoTicket>): WinningInfo {
        val ranks = matchAllTickets(tickets)
        val countOfRanks = mutableMapOf(
            Rank.FIFTH to 0,
            Rank.FOURTH to 0,
            Rank.THIRD to 0,
            Rank.SECOND to 0,
            Rank.FIRST to 0
        )
        ranks
            .groupingBy { it }
            .eachCount()
            .filter { it.key != Rank.MISS }
            .forEach { countOfRanks[it.key] = it.value }
        return WinningInfo(countOfRanks)
    }
}
