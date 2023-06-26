package step2Lotto.domain.dto

import step2Lotto.domain.LottoRank

data class ProfitRateRequest(
    val purchaseAmount: Int,
    val statistics: List<LottoRank>
)
