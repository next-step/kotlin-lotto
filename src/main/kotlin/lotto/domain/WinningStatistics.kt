package lotto.domain

data class WinningStatistics(
    val purchaseAmount: Int,
    val statistics: Map<LottoRank, Int>,
) {
    val returnRate: Double
        get() = returnAmount().toDouble() / purchaseAmount.toDouble()

    private fun returnAmount(): Int =
        statistics.keys.sumOf { key ->
            statistics[key]?.times(key.winningAmount) ?: 0
        }
}
