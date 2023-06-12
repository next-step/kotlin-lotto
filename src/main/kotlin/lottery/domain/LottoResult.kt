package lottery.domain

data class LottoResult(
    val yield: Double,
    val statistics: Map<Rank, Int>
)
