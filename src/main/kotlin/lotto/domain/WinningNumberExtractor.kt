package lotto.domain

object WinningNumberExtractor {
    fun process(lottoTicketBundle: LottoTicketBundle, winningNumbers: WinningNumbers): LottoWinning {
        val resultMap = mutableMapOf<TicketResult, Int>()
        lottoTicketBundle.lottoTickets.groupingBy { ticket ->
            val intersectNumbers = ticket.intersect(winningNumbers)
            val isBonusBallMatched = winningNumbers.bonusBall in ticket
            TicketResult(intersectNumbers.size, isBonusBallMatched)
        }.eachCountTo(resultMap)

        return LottoWinning(resultMap.toSortedMap(getTicketResultComparator()))
    }

    private fun getTicketResultComparator(): Comparator<TicketResult> =
        Comparator.comparing(TicketResult::matchCount)
            .thenComparing(TicketResult::isBonusBallMatched)
}

data class TicketResult(
    val matchCount: Int,
    val isBonusBallMatched: Boolean,
)
