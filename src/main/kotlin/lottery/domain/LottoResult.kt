package lottery.domain

import java.math.BigDecimal

data class LottoResult(
    val yield: BigDecimal,
    val statistics: Map<Rank, Int>
)
