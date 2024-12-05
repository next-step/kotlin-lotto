package lotto.domain

class LottoTicket(tickets: List<Lotto>) {
    private val _tickets = tickets.deepCopy()

    val tickets: List<Lotto>
        get() = _tickets

    private fun List<Lotto>.deepCopy(): List<Lotto> = map { it.copy() }
}
