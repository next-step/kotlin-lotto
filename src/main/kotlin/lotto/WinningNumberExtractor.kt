package lotto

import lotto.domain.LottoTicket
import lotto.domain.LottoWinning

class WinningNumberExtractor {
    fun process(tickets: List<LottoTicket>, winningNumbers: Set<Int>): LottoWinning {
        val resultMap = mutableMapOf<Int, Int>()
        tickets.forEach { ticket ->
            val intersectNumbers = ticket.numbers.intersect(winningNumbers)
            resultMap[intersectNumbers.size]?.let {
                resultMap[intersectNumbers.size] = it.inc()
            } ?: run {
                resultMap.put(intersectNumbers.size, 1)
            }
        }

        return LottoWinning(resultMap.toSortedMap())
    }
}
