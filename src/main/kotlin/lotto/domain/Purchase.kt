package lotto.domain

data class Purchase(
    val autoTickets: LottoTickets,
    val manualTickets: LottoTickets
)
