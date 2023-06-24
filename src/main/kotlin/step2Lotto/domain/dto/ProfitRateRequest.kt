package step2Lotto.domain.dto

data class ProfitRateRequest(
    val purchaseAmount: Int,
    val statistics: List<LottoRank>
)
