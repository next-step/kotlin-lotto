package lotto.domain

class LottoTicketBundle(size: Int) {
    val lottoTickets: List<LottoTicket> = List(size) {
        LottoTicket()
    }
}
