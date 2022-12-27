package lotto.domain

object WinningNumberExtractor {
    fun process(lottoTicketBundle: LottoTicketBundle, winningBalls: WinningBalls): LottoWinningResult {
        val resultMap = mutableMapOf<TicketResult, Int>()
        lottoTicketBundle.lottoTickets.groupingBy { ticket ->
            val intersectNumbers = ticket.intersect(winningBalls)
            val isBonusBallMatched = winningBalls.bonusBall in ticket
            TicketResult(intersectNumbers.size, isBonusBallMatched)
        }.eachCountTo(resultMap)

        return LottoWinningResult(resultMap.toSortedMap(getTicketResultComparator()))
    }

    private fun getTicketResultComparator(): Comparator<TicketResult> =
        Comparator.comparing(TicketResult::matchCount)
            .thenComparing(TicketResult::isBonusBallMatched)
}

data class TicketResult(
    val matchCount: Int,
    val isBonusBallMatched: Boolean,
)
