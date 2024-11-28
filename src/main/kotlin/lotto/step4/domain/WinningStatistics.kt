package lotto.step4.domain

data class WinningStatistics(
    val rankMap: Map<Rank, Int>,
    val profit: Double,
)
