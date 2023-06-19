package lotto.domain

data class LottosStatistics(
    val prizeMap: Map<LottoPrizes, Int>,
    val totalPrizeMoney: Int,
    val rateOfReturn: Double
)
