package Lotto.domain.dto

import Lotto.domain.LottoRank

data class ProfitRateRequest(
    val purchaseAmount: Int,
    val statistics: List<LottoRank>
)
