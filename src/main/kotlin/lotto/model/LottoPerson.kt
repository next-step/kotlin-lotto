package lotto.model

class LottoPerson(purchasePrice: Int) {
    val lottoTickets = LottoGenerator.generateTickets(purchasePrice / LottoTicket.TICKET_PRICE) { this.shuffled() }
}
