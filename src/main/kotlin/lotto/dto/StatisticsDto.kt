package lotto.dto

import lotto.domain.LottoPrize
import lotto.domain.PositiveNumber

data class StatisticsDto(
    val prizeRankCount: List<PrizeRankCountDto>,
    val profitRate: Double
) {

    companion object {
        fun of(prizeRankCount: Map<LottoPrize, PositiveNumber>, profitRate: Double): StatisticsDto {
            return StatisticsDto(prizeRankCount.map { (key, value) -> PrizeRankCountDto(key, value) }, profitRate)
        }
    }
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
