package lotto.entity

class MatcherImpl(private val winningNumbers: List<Int>) : Matcher {
    override fun matchOneTicket(ticket: LottoTicket): Int {
        return ticket.numbers.intersect(this.winningNumbers.toSet()).count()
    }

    override fun matchAllTickets(tickets: List<LottoTicket>): List<Int> {
        return tickets.map { ticket -> matchOneTicket(ticket) }
    }

    override fun matchTicketsToRanks(tickets: List<LottoTicket>): Map<Int, Int> {
        val ranks = matchAllTickets(tickets)
        val winningRanks = mutableMapOf(3 to 0, 4 to 0, 5 to 0, 6 to 0)
        ranks.map { it -> if (it < MINIMUM_VALID_WINNING_RANK) 0 else it }
            .groupingBy { it }
            .eachCount()
            .filter { it.key != 0 }
            .forEach { it -> winningRanks[it.key] = it.value }
        return winningRanks
    }

    companion object {
        const val MINIMUM_VALID_WINNING_RANK = 3
    }
}
