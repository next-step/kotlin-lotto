package lotto.domain

import lotto.domain.LottoPrice.Companion.LOTTO_PRICE
import kotlin.math.floor

@JvmInline
value class LottoResult(val value: Map<LottoRank, Int>) {
    fun calculateProfitRate(): Float {
        val totalWinningMoney = value.entries.sumOf { it.key.winningMoney * it.value }
        val amountOfPurchase = value.values.sum() * LOTTO_PRICE
        return floorPowerOfTwo(totalWinningMoney.toFloat() / amountOfPurchase)
    }

    private fun floorPowerOfTwo(result: Float) = floor(result * 100) / 100
}
