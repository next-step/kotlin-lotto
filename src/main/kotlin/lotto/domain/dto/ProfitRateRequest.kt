package lotto.domain.dto

import lotto.domain.LottoRank
import lotto.domain.PurchaseAmount

data class ProfitRateRequest(
    val purchaseAmount: PurchaseAmount,
    val statistics: List<LottoRank>
)
