package lotto.dto

import lotto.domain.LottoPrize
import lotto.domain.PositiveNumber

data class StatisticsDto(
    val prizeRankCount: List<PrizeRankCountDto>,
    val profitRate: Double
) {
    constructor(prizeRankCount: Map<LottoPrize, PositiveNumber>, profitRate: Double) : this(
        prizeRankCount = prizeRankCount.map { PrizeRankCountDto(it.key, it.value) },
        profitRate = profitRate
    )
}

data class PrizeRankCountDto(
    val matchedCount: Int,
    val reward: Long,
    val winnerCount: Int
) {
    constructor(lottoPrize: LottoPrize, winnerCount: PositiveNumber) : this(
        matchedCount = lottoPrize.count,
        reward = lottoPrize.reward.value,
        winnerCount = winnerCount.value
    )
}
