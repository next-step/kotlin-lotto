package lotto.domain

class LottoTicketBundle(count: Int) {
    val lottoTickets: List<LottoTicket> = List(count) {
        LottoTicket()
    }
}
