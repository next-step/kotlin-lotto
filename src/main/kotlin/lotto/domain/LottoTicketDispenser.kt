package lotto.domain

class LottoTicketDispenser(
    private val lottoTicketGenerator: LottoTicketGenerateStrategy
) {
    fun getAutoTickets(money: Int): LottoTickets {
        return IntRange(1, getTicketCount(money))
            .map { lottoTicketGenerator.createAutoTicket() }
            .let { LottoTickets(it) }
    }

    private fun getTicketCount(money: Int) = money / LottoTicket.PRICE
}
