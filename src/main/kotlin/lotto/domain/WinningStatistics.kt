package lotto

data class WinningStatistics(
    val map: Map<RewardType, Int>, // TODO: map 이름 변경하기
    val profit: Double,
)