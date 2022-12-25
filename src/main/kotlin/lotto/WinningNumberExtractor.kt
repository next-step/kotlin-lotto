package lotto

import lotto.domain.LottoTicket
import lotto.domain.LottoWinning
import java.util.Comparator

object WinningNumberExtractor {
    fun process(tickets: List<LottoTicket>, winningNumbers: Set<Int>, bonusBall: Int): LottoWinning {
        val resultMap = mutableMapOf<TicketResult, Int>()
        tickets.forEach { ticket ->
            val intersectNumbers = ticket.numbers.intersect(winningNumbers)
            val isBonusBallMatched = bonusBall in ticket.numbers
            val ticketResult = TicketResult(intersectNumbers.size, isBonusBallMatched)
            resultMap[ticketResult]?.let {
                resultMap[ticketResult] = it.inc()
            } ?: run {
                resultMap.put(ticketResult, 1)
            }
        }

        return LottoWinning(
            resultMap.toSortedMap(
                Comparator.comparing(TicketResult::matchCount)
                    .thenComparing(TicketResult::isBonusBallMatched)
            )
        )
    }
}

data class TicketResult(
    val matchCount: Int,
    val isBonusBallMatched: Boolean,
)
