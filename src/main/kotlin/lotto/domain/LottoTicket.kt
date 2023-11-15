package lotto.domain

class LottoTicket(
    val numbers: List<LottoNumber>,
) {

    val count: Int
        get() = numbers.size

    infix fun determineResultBy(winningLotto: WinningLotto): LottoRankCounts =
        createResult(winningLotto)

    infix fun calculateTotalPriceBy(ticketPrice: Amount) = ticketPrice * numbers.size

    private fun createResult(winningLotto: WinningLotto) =
        numbers.map { winningLotto.rank(it) }.groupingBy { it }.eachCount().let(::LottoRankCounts)
}
