package lotto.business

class TicketBookingSystem(private val lottoTicketGenerator: LottoTicketGenerator) {
    fun buyLotto(money: Int): List<LottoTicket> {
        val count = getTicketCount(money)
        return lottoTicketGenerator.generate(count)
    }

    fun getTicketCount(money: Int): Int {
        return money / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
