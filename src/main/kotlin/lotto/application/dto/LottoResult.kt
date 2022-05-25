package lotto.application.dto

import lotto.domain.MatchType

data class LottoResult(
    val winningRate: Double,
    val winningResults: Map<MatchType, Int>
)
