package lotto.entity

class MatcherImpl(private val winningNumbers: List<Int>) : Matcher {

    override fun matchOneTicket(ticket: LottoTicket): Int {
        return ticket.numbers.intersect(this.winningNumbers.toSet()).count()
    }

    override fun matchAllTickets(tickets: List<LottoTicket>): List<Int> {
        return tickets.map { ticket -> matchOneTicket(ticket) }
    }
}
