package lotto.domain

object WinningNumberExtractor {
    fun process(lottoTicketBundle: LottoTicketBundle, winningBallResult: WinningBallResult): LottoWinningResult {
        val resultMap = mutableMapOf<LottoTicketResult, Int>()
        lottoTicketBundle.lottoTickets.groupingBy { ticket ->
            val intersectNumbers = ticket.intersect(winningBallResult.winningBalls)
            val isBonusBallMatched = winningBallResult.bonusBall in ticket
            LottoTicketResult(intersectNumbers.size, isBonusBallMatched)
        }.eachCountTo(resultMap)

        return LottoWinningResult(resultMap.toSortedMap(getTicketResultComparator()))
    }

    private fun getTicketResultComparator(): Comparator<LottoTicketResult> =
        Comparator.comparing(LottoTicketResult::matchCount)
            .thenComparing(LottoTicketResult::isBonusBallMatched)
}
