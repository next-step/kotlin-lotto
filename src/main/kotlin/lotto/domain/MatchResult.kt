package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class MatchResult(private val ranks: List<Rank> = emptyList()) {
    fun rateOfReturn(money: Int): BigDecimal {
        return ranks.sumOf { it.winningAmount }
            .toBigDecimal()
            .divide(money.toBigDecimal(), 2, RoundingMode.DOWN)
    }

    fun countOf(rank: Rank): Int {
        return ranks.count { it == rank }
    }
}
