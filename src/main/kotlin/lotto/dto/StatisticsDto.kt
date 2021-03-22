package lotto.dto

import lotto.domain.LottoPrize
import lotto.domain.PositiveNumber

data class StatisticsDto(val prizeRankCount: Map<LottoPrize, Int>, val profitRate: Double) {

    companion object {
        fun of(prizeRankCount: Map<LottoPrize, PositiveNumber>, profitRate: Double): StatisticsDto {
            return StatisticsDto(prizeRankCount.mapValues { it.value.value }, profitRate)
        }
    }
}
