package lotto.dto

import lotto.domain.LottoPrize
import java.math.BigDecimal

data class StatisticsDto(val prizeRankCount: Map<LottoPrize, Int>, val profitRate: Double) {

    companion object {
        fun of(result: List<LottoPrize>, amount: Int): StatisticsDto {
            val prizeRankCount = result
                .filter { it != LottoPrize.WHACK }
                .groupingBy { it }
                .eachCount()

            val allRewards = result
                .map { it.reward }
                .map { it.toLong() }
                .sum()

            val profitRate = BigDecimal(allRewards).divide(BigDecimal(amount))

            return StatisticsDto(prizeRankCount, profitRate.toDouble())
        }
    }
}
