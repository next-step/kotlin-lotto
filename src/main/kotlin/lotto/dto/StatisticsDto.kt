package lotto.dto

import lotto.domain.LottoPrize

data class StatisticsDto(val prizeRankCount: Map<LottoPrize, Int>, val profitRate: Double)
