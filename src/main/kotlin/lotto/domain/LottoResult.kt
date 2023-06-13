package lotto.domain

data class LottoResult(
    val winningStatistics: Map<Rank, Int>,
    val profitRate: ProfitRate
)
