package lotto.business

class TicketBookingSystem(private val lottoTicketGenerator: LottoTicketGenerator) {
    fun buyLotto(amount: ReceivedAmount): List<LottoTicket> =
        lottoTicketGenerator.generateMultipleTickets(amount.getTicketCount())
}
