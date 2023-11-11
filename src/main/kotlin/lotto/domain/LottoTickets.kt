package lotto.domain

data class LottoTickets(
    val tickets: List<LottoTicket>,
) {

    infix fun determineResultBy(winningLotto: WinningLotto): LottoResult =
        tickets.map { winningLotto.rank(it) }.groupingBy { it }.eachCount().let(::LottoResult)

    fun calculatePrice(ticketPrice: Amount) = ticketPrice * tickets.size

    val count: Int
        get() = tickets.size
}
