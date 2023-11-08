package lotto.domain

data class LottoMatchResult(
    val result: Map<LottoRank, Int>,
    val earningRate: Double,
)
