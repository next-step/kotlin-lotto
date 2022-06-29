package lotto.entity

interface Matcher {
    fun matchAllTickets(tickets: List<LottoTicket>): List<Rank>
    fun matchOneTicket(ticket: LottoTicket): Rank
    fun countTicketRanks(tickets: List<LottoTicket>): WinningInfo
}
