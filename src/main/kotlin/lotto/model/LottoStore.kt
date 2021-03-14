package lotto.model

class LottoStore {
    fun buy(moneyAmount: Money): LottoTickets {
        val affordableTicketsCount = (moneyAmount / LottoTicket.PRICE).toInt()

        return LottoTickets.issue(affordableTicketsCount)
    }
}
