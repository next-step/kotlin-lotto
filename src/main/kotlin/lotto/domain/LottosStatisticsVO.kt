package lotto.domain

data class LottosStatisticsVO(
    val prizeMap: Map<LottoPrizes, Int>,
    val totalPrizeMoney: Int,
    val rateOfReturn: Double
)
