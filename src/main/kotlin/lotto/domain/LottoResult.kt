package lotto.domain

import lotto.domain.LottoPrice.Companion.LOTTO_PRICE
import lotto.dto.LottoRankDto
import kotlin.math.floor

@JvmInline
value class LottoResult(private val value: Map<LottoRank, Int>) {
    fun calculateProfitRate(): Float {
        val totalWinningMoney = value.entries.sumOf { it.key.winningMoney * it.value }
        val amountOfPurchase = value.values.sum() * LOTTO_PRICE
        return floorPowerOfTwo(totalWinningMoney.toFloat() / amountOfPurchase)
    }

    fun getResultAsDto(): Map<LottoRankDto, Int> {
        return value.mapKeys { LottoRankDto(it.key.countOfMatch, it.key.winningMoney) }
    }

    fun getNumberOfWinningsByRank(rank: LottoRank): Int {
        return value[rank] ?: 0
    }

    private fun floorPowerOfTwo(result: Float) = floor(result * 100) / 100
}
