package lotto.domain

object WinningNumberExtractor {
    fun process(lottoTicketBundle: LottoTicketBundle, winningBallResult: WinningBallResult): LottoWinningResult {
        val resultMap = mutableMapOf<TicketResult, Int>()
        lottoTicketBundle.lottoTickets.groupingBy { ticket ->
            val intersectNumbers = ticket.intersect(winningBallResult.winningBalls)
            val isBonusBallMatched = winningBallResult.bonusBall in ticket
            TicketResult(intersectNumbers.size, isBonusBallMatched)
        }.eachCountTo(resultMap)

        return LottoWinningResult(resultMap.toSortedMap(getTicketResultComparator()))
    }

    private fun getTicketResultComparator(): Comparator<TicketResult> =
        Comparator.comparing(TicketResult::matchCount)
            .thenComparing(TicketResult::isBonusBallMatched)
}
