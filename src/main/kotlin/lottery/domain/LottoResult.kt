package lottery.domain

import java.math.BigDecimal

data class LottoResult(
    val lottoYield: BigDecimal,
    val statistics: Map<Rank, Int>
)
