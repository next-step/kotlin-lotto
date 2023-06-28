package lotto.vo

import lotto.domain.WinningMap

data class LottosStatisticsVO(
    val prizeMap: WinningMap,
    val totalPrizeMoney: Int,
    val rateOfReturn: Double
)
