package lotto.business

class TicketBookingSystem(private val lottoTicketGenerator: LottoTicketGenerator) {
    fun buyLotto(amount: ReceivedAmount): List<LottoTicket> = lottoTicketGenerator.generate(amount.getTicketCount())
}
