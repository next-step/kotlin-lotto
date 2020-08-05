package lotto.domain

class LottoTickets(
    private val tickets: List<LottoTicket>
) {
    operator fun plus(other: LottoTickets): LottoTickets {
        return LottoTickets(this.tickets + other.tickets)
    }

    fun compare(luckyTicket: LottoTicket): Map<LottoResult, Int> {
        return this.tickets.map { it.compare(luckyTicket) }
            .groupingBy { it }
            .eachCount()
    }
}
