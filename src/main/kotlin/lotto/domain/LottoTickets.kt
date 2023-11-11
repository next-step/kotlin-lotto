package lotto.domain

class LottoTickets(
    val tickets: List<LottoTicket>,
    private var _result: LottoResult? = null
) {

    val count: Int
        get() = tickets.size

    var result: LottoResult?
        get() = _result
        private set(value) {
            _result = value
        }

    infix fun determineResultBy(winningLotto: WinningLotto): LottoResult =
        createResult(winningLotto).also {
            this.result = it
        }

    fun calculatePrice(ticketPrice: Amount) = ticketPrice * tickets.size

    private fun createResult(winningLotto: WinningLotto) =
        tickets.map { winningLotto.rank(it) }.groupingBy { it }.eachCount().let(::LottoResult)
}
