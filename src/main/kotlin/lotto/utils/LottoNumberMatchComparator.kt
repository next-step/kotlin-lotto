package lotto.utils

import lotto.domain.LottoStatistics
import lotto.domain.LottoTicket
import lotto.domain.WinningAmount

object LottoNumberMatchComparator {
    fun compare(ticketBundle: List<LottoTicket>, winningNumber: Set<Int>): LottoStatistics {
        val rank = ticketBundle
            .map {
                it.numbers.intersect(winningNumber).size
            }
            .groupingBy { WinningAmount.from(it) }
            .eachCount()

        return LottoStatistics(rank)
    }
}
