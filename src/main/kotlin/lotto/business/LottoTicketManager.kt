package lotto.business

class LottoTicketManager(
    tickets: List<LottoTicket> = mutableListOf(),
    private val ticketBookingSystem: TicketBookingSystem = TicketBookingSystem(LottoTicketGenerator())
) {
    private val _tickets: MutableList<LottoTicket> = tickets.toMutableList()

    private val tickets: List<LottoTicket>
        get() = _tickets.toList()

    fun buyLotto(receivedAmount: ReceivedAmount): List<LottoTicket> {
        this._tickets.addAll(ticketBookingSystem.buyLotto(receivedAmount))
        return tickets
    }
}
