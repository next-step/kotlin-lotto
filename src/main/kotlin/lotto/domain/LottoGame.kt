package lotto.domain

object LottoGame {
    fun generateTickets(amount: Int): List<Lotto> {
        val ticketCount = LottoCalculator.calculateTicketCount(amount)
        return List(ticketCount) { LottoGenerator.generateTicket() }
    }
}
