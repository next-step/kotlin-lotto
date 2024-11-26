package lotto.view.dto

import lotto.domain.LottoResult

data class WinningResult(
    val winningMatchCounts: List<LottoResult>,
    val revenue: Int,
    val rate: Int,
)
