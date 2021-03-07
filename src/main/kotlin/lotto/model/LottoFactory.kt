package lotto.model

class LottoFactory {
    companion object {
        fun issue(ticketCount: Int): LottoTickets {
            return LottoTickets((1..ticketCount).map { LottoTicket() })
        }
    }
}
