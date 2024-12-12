package lotto.domain

data class LottoTicket(val tickets: List<Lotto>) {
    fun flatLottos(vararg additionalTickets: LottoTicket): LottoTicket {
        return LottoTicket(
            tickets + additionalTickets.flatMap { it.tickets },
        )
    }
}
