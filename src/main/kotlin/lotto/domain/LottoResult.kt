package lotto.domain

import java.math.BigDecimal

class LottoResult(private val result: Map<Winning, Int>) {
    fun getWinningCount(winning: Winning): Int = result[winning] ?: 0

    fun getTotalAmount(): BigDecimal {
        return result.keys.sumOf { winning ->
            (winning.winningAmount * getWinningCount(winning)).toBigDecimal()
        }
    }

    fun getTotalCount(): Int = result.values.sum()
}
