package lotto.domain

import lotto.domain.model.Rank
import kotlin.math.floor

class LottoStatics(private val ranks: List<Rank> = emptyList()) {

    val totalReward: Int = calculateTotalReward()

    val winningResult: Map<Rank, Int>
        get() = calculateWinningCount()

    private fun calculateTotalReward(): Int {
        return ranks.sumOf { rank -> rank.prize }
    }

    private fun calculateWinningCount(): Map<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()
        ranks.forEach { rank ->
            result[rank] = result[rank]?.inc() ?: 1
        }
        return result
    }

    fun calculateEarningRate(prize: Int, amount: Int): Float {
        val result: Float = prize.toFloat().div(amount.toFloat())
        return floor(result * 100).div(100f)
    }
}
