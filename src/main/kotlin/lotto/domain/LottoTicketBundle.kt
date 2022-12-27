package lotto.domain

import lotto.common.LottoTicketPolicy

data class LottoTicketBundle(val amount: Int) {
    private val count = amount / LottoTicketPolicy.PRICE

    val lottoTickets: List<LottoTicket> = List(count) {
        LottoTicket()
    }
}
