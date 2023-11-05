package lotto.domain

class LottoManager(
    private val ticketGenerator: LottoTicketGenerator = LottoTicketGenerator(),
    private val ticketStorage: LottoTicketStorage = LottoTicketStorage(),
) {
    fun createTicket(count: TicketCount): List<LottoTicket> {
        val tickets = List(count.value) {
            ticketGenerator.create()
        }
        ticketStorage.save(tickets)
        return tickets
    }
}
