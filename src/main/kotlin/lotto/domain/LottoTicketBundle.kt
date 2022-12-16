package lotto.domain

import lotto.common.LottoTicketPolicy

class LottoTicketBundle(amount: Int) {
    private val count = amount / LottoTicketPolicy.PRICE
    val lottoTickets: List<LottoTicket> = List(count) {
        LottoTicket()
    }
}
