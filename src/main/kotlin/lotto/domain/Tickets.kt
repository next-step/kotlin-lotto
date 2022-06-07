package lotto.domain

class Tickets(private val _tickets: List<Lotto>) {
    private val tickets = _tickets.toMutableList()

    fun count(): Int = tickets.size

    fun getResult(winner: WinnerLotto): LottoResult {
        return LottoResult(tickets.groupingBy { WinningMatcher(winner).getPlace(it) }.eachCount())
    }

    fun formatToPrint(): List<String> = tickets.map { it.formatToTickets() }

    fun merge(otherTickets: Tickets): Tickets {
        tickets.addAll(otherTickets.tickets)
        return this
    }
}
