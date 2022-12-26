package lotto.domain

import lotto.domain.model.Rank
import kotlin.math.floor

class LottoStatics(private val ranks: List<Rank> = emptyList()) {

    val totalReward: Int = calculateTotalReward()

    val winningResult: WinningResult
        get() = WinningResult.calculateWinningCount(ranks)

    private fun calculateTotalReward(): Int = ranks.sumOf { rank -> rank.prize }

    fun calculateEarningRate(prize: Int, amount: Int): Float {
        val result: Float = prize.toFloat().div(amount.toFloat())
        return floor(result * 100).div(100f)
    }
}
