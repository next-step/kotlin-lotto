package lotto

class LottoShop(
    private val lottoTicketGenerator: LottoTicketGenerateStrategy
) {
    private val luckyLottoTicket = lottoTicketGenerator.createAutoTicket()

    fun getAutoTickets(money: Int): List<LottoTicket> {
        return IntRange(1, getTicketCount(money))
            .map { lottoTicketGenerator.createAutoTicket() }
    }

    private fun getTicketCount(money: Int) = money / LottoTicket.PRICE

    fun getLottoResultsOf(lottoTickets: List<LottoTicket>): List<LottoResult> {
        return lottoTickets.map { it.compare(luckyLottoTicket) }
    }
}
