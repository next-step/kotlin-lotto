package lottery.domain

import lottery.domain.rank.Rank
import java.math.BigDecimal

data class LottoResult(
    val lottoYield: BigDecimal,
    val statistics: Map<Rank, Int>,
)
