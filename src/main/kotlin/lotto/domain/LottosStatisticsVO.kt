package lotto.domain

data class LottosStatisticsVO(
    val prizeMap: WinningMap,
    val totalPrizeMoney: Int,
    val rateOfReturn: Double
)
