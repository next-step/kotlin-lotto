package lotto.domain

data class LottoTicketBundle(
    val lottoTicketCount: LottoTicketCount,
) {
    val lottoTickets: List<LottoTicket> = List(lottoTicketCount.autoTicketCount) {
        LottoTicket(LottoNumberSelector.select())
    }
}
