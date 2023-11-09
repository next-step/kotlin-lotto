package lotto.model

import lotto.utils.MatchedCount
import lotto.utils.TicketCount

class LottoResult(
    val lottoPrizes: List<LottoPrize>,
    val revenueRate: Double
) {
    fun groupLottoPrizesByMatchedCount(): Map<MatchedCount, TicketCount> {
        return lottoPrizes
            .groupBy { it.matchedCount }
            .mapValues { it.value.size }
    }
}
