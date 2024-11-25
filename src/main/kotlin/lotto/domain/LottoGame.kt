package lotto.domain

object LottoGame {
    fun generateTickets(amount: Int): List<Lotto> {
        val ticketCount = LottoPurchaseCalculator.calculateTicketCount(amount)
        return List(ticketCount) { LottoGenerator.generateTicket() }
    }
}
