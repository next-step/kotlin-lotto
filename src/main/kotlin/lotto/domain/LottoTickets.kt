package lotto.domain

data class LottoTickets(
    private val lottoTickets: List<LottoTicket>
) {
    fun get() = lottoTickets.toList()
}
