package lottogame.domain.lotto

import lottogame.domain.GameMoney
import lottogame.domain.rank.Rank
import java.math.BigDecimal
import java.math.RoundingMode

data class MatchResult(private val ranks: List<Rank> = emptyList()) {
    fun rateOfReturn(gameMoney: GameMoney): BigDecimal {
        return ranks.sumOf { it.winningAmount.value }
            .divide(gameMoney.value, 2, RoundingMode.DOWN)
    }

    fun countOf(rank: Rank): Int {
        return ranks.count { it == rank }
    }
}
