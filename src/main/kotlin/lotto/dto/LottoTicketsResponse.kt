package lotto.dto

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

data class LottoTicketsResponse(
    val lottoTickets: List<LottoTicketResponse>,
    val autoCount: Int,
    val manualCount: Int
) {

    companion object {
        fun of(lottoTickets: LottoTickets, manualCount: Int): LottoTicketsResponse {
            val tickets = lottoTickets.lottoTickets
            return LottoTicketsResponse(
                lottoTickets = tickets.map(LottoTicketResponse::of),
                autoCount = tickets.size - manualCount,
                manualCount = manualCount,
            )
        }
    }

    data class LottoTicketResponse(
        val lottoNumbers: List<Int>,
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
}
