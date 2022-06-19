package lotto.entity

interface Matcher {
    fun matchAllTickets(tickets: List<LottoTicket>): List<Int>
    fun matchOneTicket(ticket: LottoTicket): Int
    fun countTicketRanks(tickets: List<LottoTicket>): WinningInfo
}
