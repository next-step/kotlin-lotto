package lotto.domain.collection

import lotto.domain.LottoTicket

data class LottoTickets(
    private val lottoTickets: List<LottoTicket>
) {
    fun getLottoTickets() = lottoTickets
}
