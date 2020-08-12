package lotto.domain

class LottoTicketDispenser(
    private val lottoTicketGenerator: LottoTicketGenerateStrategy
) {
    fun getAutoTickets(money: LottoMoney): LottoTickets {
        return IntRange(1, money.ticketCountCanBuy)
            .map { lottoTicketGenerator.createAutoTicket() }
            .let { LottoTickets(it) }
    }

    fun getManualTickets(numbersList: List<IntArray>): LottoTickets {
        return LottoTickets(numbersList.map { lottoTicketGenerator.createManualTicket(it) })
    }
}
