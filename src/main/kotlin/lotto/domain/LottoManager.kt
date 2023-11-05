package lotto.domain

class LottoManager(
    private val ticketGenerator: LottoTicketGenerator = LottoTicketGenerator(),
) {
    fun createTicket(count: TicketCount): List<LottoTicket> =
        List(count.value) {
            ticketGenerator.create()
        }
}
