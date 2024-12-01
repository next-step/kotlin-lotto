package lotto.domain

data class Tickets(
    val manualTickets: List<ManualTicket>,
    val autoTickets: List<AutoTicket>,
)

data class ManualTicket(val lottoNumbers: LottoNumbers)

object AutoTicket
