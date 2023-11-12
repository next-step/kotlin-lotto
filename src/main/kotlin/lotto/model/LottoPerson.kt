package lotto.model

class LottoPerson(private val lottoGenerator: LottoGenerator) {
    fun buyLottoTickets(purchasePrice: Int): List<LottoTicket> =
        lottoGenerator.generateTickets(purchasePrice / LottoTicket.TICKET_PRICE) { this.shuffled() }

}
