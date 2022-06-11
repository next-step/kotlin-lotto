package lotto.domain

data class Purchase(
    val autoTickets: LottoTickets,
    val manualTickets: LottoTickets
) {
    val totalTickets = manualTickets + autoTickets
    val manualTicketSize = manualTickets.ticketSize
    val autoTicketSize = autoTickets.ticketSize
}
