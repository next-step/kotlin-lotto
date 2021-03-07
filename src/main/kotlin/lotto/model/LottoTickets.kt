package lotto.model

data class LottoTickets(private val lottoTickets: List<LottoTicket>) : List<LottoTicket> by lottoTickets {
    companion object {
        fun issue(ticketCount: Int): LottoTickets =
            LottoTickets((1..ticketCount).map { LottoTicket() })
    }
}
