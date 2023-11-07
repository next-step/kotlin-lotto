package lotto.domain

data class LottoResult(
    val profit: Long,
    val netSpent: Int,
    val remainder: Int,
    val profitRate: Double,
    val rankResult: Map<Rank, Int>
)
