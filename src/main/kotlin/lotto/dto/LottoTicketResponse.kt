package lotto.dto

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

data class LottoTicketResponse(
    val lottoNumbers: List<Int>
) {
    companion object {
        fun listOf(lottoTickets: LottoTickets): List<LottoTicketResponse> {
            return lottoTickets.lottoTickets
                .map(::of)
        }

        fun of(lottoTicket: LottoTicket): LottoTicketResponse {
            val lottoNumbers = lottoTicket.lottoNumbers
                .map { it.number }
                .sorted()
            return LottoTicketResponse(lottoNumbers)
        }
    }
}
