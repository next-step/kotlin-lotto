package lotto.view.dto

import lotto.domain.RankResult

data class WinningResult(
    val winningMatchCounts: List<RankResult>,
    val revenue: Int,
    val rate: Double,
)
