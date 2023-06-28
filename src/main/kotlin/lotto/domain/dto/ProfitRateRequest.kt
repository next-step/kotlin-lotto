package lotto.domain.dto

import lotto.domain.LottoRank

data class ProfitRateRequest(
    val purchaseAmount: Int,
    val statistics: List<LottoRank>
)
