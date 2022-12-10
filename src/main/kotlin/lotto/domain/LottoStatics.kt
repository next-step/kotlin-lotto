package lotto.domain

import lotto.domain.model.Rank
import kotlin.math.floor

class LottoStatics(private val ranks: List<Rank> = emptyList()) {

    val totalReward: Int = calculateTotalReward()

    val winningResult: Map<Int, Int>
        get() = calculateWinningCount()

    private fun calculateTotalReward(): Int {
        return ranks.sumOf { rank -> rank.prize }
    }

    private fun calculateWinningCount(): Map<Int, Int> {
        val result = mutableMapOf(
            Rank.FIRST_GRADE.matchCount to 0,
            Rank.SECOND_GRADE.matchCount to 0,
            Rank.THIRD_GRADE.matchCount to 0,
            Rank.FOURTH_GRADE.matchCount to 0,
            Rank.FIFTH_GRADE.matchCount to 0,
            Rank.NO_MATCH.matchCount to 0,
        )
        ranks.forEach { rank ->
            result[rank.matchCount] = result[rank.matchCount]?.inc() ?: 0
        }
        return result
    }

    fun calculateEarningRate(prize: Int, amount: Int): Float {
        val result: Float = prize.toFloat().div(amount.toFloat())
        return floor(result * 100).div(100f)
    }
}
