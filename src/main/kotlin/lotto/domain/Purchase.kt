package lotto.domain

data class Purchase(
    val autoTickets: LottoTickets,
    val manualTickets: LottoTickets
) {
    val totalTickets = LottoTickets(manualTickets.lottoTickets + autoTickets.lottoTickets)
    val manualTicketSize = manualTickets.lottoTickets.size
    val autoTicketSize = autoTickets.lottoTickets.size
}
