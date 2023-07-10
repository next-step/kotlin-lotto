package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class MatchResult(private val matches: List<Match> = emptyList()) {
    fun rateOfReturn(money: Int): BigDecimal {
        return matches.sumOf { it.winningAmount }
            .toBigDecimal()
            .divide(money.toBigDecimal(), 2, RoundingMode.DOWN)
    }

    fun countOf(match: Match): Int {
        return matches.count { it == match }
    }
}
