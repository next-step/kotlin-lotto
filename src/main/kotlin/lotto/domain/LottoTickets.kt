package lotto.domain

class LottoTickets(
    val tickets: List<LottoTicket>,
) {

    val count: Int
        get() = tickets.size

    infix fun determineResultBy(winningLotto: WinningLotto): LottoRankCounts =
        createResult(winningLotto)

    fun calculatePrice(ticketPrice: Amount) = ticketPrice * tickets.size

    private fun createResult(winningLotto: WinningLotto) =
        tickets.map { winningLotto.rank(it) }.groupingBy { it }.eachCount().let(::LottoRankCounts)
}
