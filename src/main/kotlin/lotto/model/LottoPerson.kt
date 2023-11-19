package lotto.model

class LottoPerson(private val lottoGenerator: LottoGenerator) {
    fun buyLottoTickets(purchasePrice: Int, manualNumbers: List<List<LottoNumber>>): List<LottoTicket> {
        val autoTicket = lottoGenerator.generateAutoTickets(
            purchasePrice / LottoTicket.TICKET_PRICE - manualNumbers.size,
        ) { this.shuffled() }
        val manualTicket = lottoGenerator.generateManualTickets(manualNumbers)
        return manualTicket + autoTicket
    }
}
