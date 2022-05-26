package lotto.domain

class LottoTickets(private val tickets: List<LottoTicket>) : List<LottoTicket> by tickets {

//    fun getMatchCount(match: LottoMatch, other: LottoTicket): Int {
//        return tickets.filter { it.getMatchCount(other) == match }.size
//    }
}
