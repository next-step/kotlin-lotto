package lotto.entity

class MatcherImpl(private val winningNumbers: List<Int>) : Matcher {
    override fun matchOneTicket(ticket: LottoTicket): Int {
        return ticket.numbers.intersect(this.winningNumbers.toSet()).count()
    }

    override fun matchAllTickets(tickets: List<LottoTicket>): List<Int> {
        return tickets.map { ticket -> matchOneTicket(ticket) }
    }

    override fun countTicketRanks(tickets: List<LottoTicket>): WinningInfo {
        val ranks = matchAllTickets(tickets)
        val countOfRanks = mutableMapOf(3 to 0, 4 to 0, 5 to 0, 6 to 0)
        ranks.map { if (it < MINIMUM_VALID_WINNING_RANK) 0 else it }
            .groupingBy { it }
            .eachCount()
            .filter { it.key != 0 }
            .forEach { countOfRanks[it.key] = it.value }
        return WinningInfo(countOfRanks)
    }

    companion object {
        const val MINIMUM_VALID_WINNING_RANK = 3
    }
}
