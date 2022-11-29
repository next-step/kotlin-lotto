package lotto.domain

import kotlin.math.floor

@JvmInline
value class LottoResult(val value: Map<LottoRank, Int>) {
    fun calculateProfitRate(amount: Int): Float {
        val totalWinningMoney = value.entries.sumOf { it.key.winningMoney * it.value }
        return floorPowerOfTwo(totalWinningMoney.toFloat() / amount)
    }

    private fun floorPowerOfTwo(result: Float) = floor(result * 100) / 100
}
