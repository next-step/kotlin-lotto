package lotto.domain.result

data class LottoMatchResult(
    val result: Map<LottoRank, Int>,
    val earningRate: Double,
)
