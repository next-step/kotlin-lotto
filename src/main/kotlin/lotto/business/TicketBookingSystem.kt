package lotto.business

class TicketBookingSystem(private val lottoTicketGenerator: LottoTicketGenerator) {
    fun buyLotto(money: Int): List<LottoTicket> {
        val count = money / 1000
        return lottoTicketGenerator.generate(count)
    }
}
