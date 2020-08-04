package lotto

class LottoShop(
    private val lottoTicketGenerator: LottoTicketGenerateStrategy
) {
    private lateinit var luckyLottoTicket: LottoTicket

    fun setLuckyLottoNumbers(numbers: List<Int>) {
        luckyLottoTicket = lottoTicketGenerator.createManualTicket(numbers)
    }

    fun getAutoTickets(money: Int): List<LottoTicket> {
        return IntRange(1, getTicketCount(money))
            .map { lottoTicketGenerator.createAutoTicket() }
    }

    private fun getTicketCount(money: Int) = money / LottoTicket.PRICE

    fun getLottoResultsOf(lottoTickets: List<LottoTicket>): List<LottoResult> {
        return lottoTickets.map { it.compare(luckyLottoTicket) }
    }
}
