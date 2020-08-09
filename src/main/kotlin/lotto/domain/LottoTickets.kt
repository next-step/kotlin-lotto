package lotto.domain

class LottoTickets(
    private val tickets: List<LottoTicket>
) {
    operator fun plus(other: LottoTickets): LottoTickets {
        return LottoTickets(this.tickets + other.tickets)
    }

    fun getLottoResultsWith(luckyTicket: LottoTicket, bonusNumber: LottoNumber): LottoResults {
        return this.tickets.map { it.getLottoResultWith(luckyTicket, bonusNumber) }
            .groupingBy { it }
            .eachCount()
            .let { LottoResults(it) }
    }

    fun size() = tickets.size

    override fun toString(): String {
        return tickets.joinToString("\n")
    }
}
