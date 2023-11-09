package lotto.model

typealias TicketCount = Int

class LottoResult(
    val lottoPrizes: List<LottoPrize>,
    val revenueRate: Double
) {
    fun groupLottoPrizesByMatchedCount(): Map<MatchedCount, TicketCount> {
        return lottoPrizes
            .groupBy { it.matchedNumber }
            .mapValues { it.value.size }
    }
}
