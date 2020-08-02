package lotto

class LottoShop(
    private val lottoTicketGenerator: LottoTicketGenerateStrategy
) {
    private val luckyLottoTicket = lottoTicketGenerator.createAutoTicket()

    fun getAutoTickets(ticketCount: Int): List<LottoTicket> {
        return IntRange(1, ticketCount)
            .map { lottoTicketGenerator.createAutoTicket() }
    }

    fun getLottoResultsOf(lottoTickets: List<LottoTicket>): List<LottoResult> {
        return lottoTickets.map { it.compare(luckyLottoTicket) }
    }
}
