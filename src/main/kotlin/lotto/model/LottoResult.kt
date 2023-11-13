package lotto.model

import lotto.utils.MatchedCount
import lotto.utils.TicketCount
import java.util.TreeMap

class LottoResult(
    val lottoPrizes: List<LottoPrize>,
    val revenueRate: Double
) {
    fun groupWinningTicketCountByMatchedCount(): TreeMap<MatchedCount, TicketCount> {
        val source = lottoPrizes
            .groupingBy { it.matchedCount }
            .eachCount()
            .filter { (matchedCount, _) -> matchedCount in validMatchedCounts }
        val target = validMatchedCounts.associateWith { 0 }

        return TreeMap<MatchedCount, TicketCount>(target + source)
    }

    companion object {
        private val validMatchedCounts = (3..6).toList()
    }
}
