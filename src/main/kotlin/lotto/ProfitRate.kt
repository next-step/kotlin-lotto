package lotto

import lotto.domain.LottoPrize
import java.math.BigDecimal

class Profit(private val prizeRankCount: Map<LottoPrize, Int>, private val purchaseAmount: Int) {

    fun rate(): Double {
        val allRewards = prizeRankCount.entries
            .sumByLong { (lottoPrize, count) -> lottoPrize.reward.toLong() * count }
        return BigDecimal(allRewards).divide(BigDecimal(purchaseAmount)).toDouble()
    }
}

private inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
    return map { selector(it) }.sum()
}
