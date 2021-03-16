package lotto.dto

import lotto.domain.LottoPrize
import java.math.BigDecimal

data class StatisticsDto(val prizeRankCount: Map<LottoPrize, Int>, val profitRate: Double) {

    companion object {
        fun of(result: Map<LottoPrize, Int>, amount: Int): StatisticsDto {
            val allRewards = result.entries
                .sumByLong { (lottoPrize, count) -> lottoPrize.reward.toLong() * count }

            val profitRate = BigDecimal(allRewards).divide(BigDecimal(amount))

            return StatisticsDto(result, profitRate.toDouble())
        }
    }
}

private inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
    return map { selector(it) }.sum()
}
