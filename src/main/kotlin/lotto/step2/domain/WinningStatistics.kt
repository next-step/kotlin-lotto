package lotto.step2.domain

data class WinningStatistics(
    val rewardMap: Map<RewardType, Int>,
    val profit: Double,
)
