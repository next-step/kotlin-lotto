package lotto

import lotto.domain.LottoTicket
import lotto.domain.LottoWinning
import lotto.domain.WinningNumbers
import java.util.Comparator

object WinningNumberExtractor {
    fun process(tickets: List<LottoTicket>, winningNumbers: WinningNumbers): LottoWinning {
        val resultMap = mutableMapOf<TicketResult, Int>()
        tickets.forEach { ticket ->
            val intersectNumbers = ticket.intersect(winningNumbers)
            val isBonusBallMatched = winningNumbers.bonusBall in ticket
            val ticketResult = TicketResult(intersectNumbers.size, isBonusBallMatched)

            resultMap[ticketResult]
                ?.let { resultMap[ticketResult] = it.inc() }
                ?: run { resultMap.put(ticketResult, 1) }
        }

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
