package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class MatchResult(private val matches: List<Match> = emptyList()) {
    fun rateOfReturn(money: Int): BigDecimal {
        return matches.sumOf { it.winningAmount }
            .toBigDecimal()
            .divide(money.toBigDecimal(), 2, RoundingMode.DOWN)
    }

    fun countOf(match: Match): Int {
        return matches.count { it == match }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MatchResult

        return matches == other.matches
    }

    override fun hashCode(): Int {
        return matches.hashCode()
    }
}
