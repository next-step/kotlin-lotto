package lotto.domain

class Tickets(private val tickets: List<Lotto>) {

    fun count(): Int = tickets.size

    fun getResult(winner: WinnerLotto): LottoResult {
        return LottoResult(tickets.groupingBy { WinningMatcher(winner).getPlace(it) }.eachCount())
    }

    fun formatToPrint(): List<String> = tickets.map { it.formatToTickets() }
}
