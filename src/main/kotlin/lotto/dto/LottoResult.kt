package lotto.dto

import lotto.entity.Rank

class LottoResult(
    val rankToInt: Map<Rank, Int>,
    val totalPrize: Long,
    val purchaseCost: Long,
)
