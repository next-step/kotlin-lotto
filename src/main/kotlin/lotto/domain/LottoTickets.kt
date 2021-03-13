package lotto.domain

class LottoTickets(val tickets: List<LottoTicket>) {
    companion object {
        fun create(count: Int): LottoTickets {
            return LottoTickets(mutableListOf<LottoTicket>()
                .also { tickets -> repeat(count) { tickets.add(LottoTicket.create()) } })
        }
    }
}
