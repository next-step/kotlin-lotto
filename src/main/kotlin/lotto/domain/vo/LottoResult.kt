package lotto.domain.vo

import lotto.domain.LottoRank

data class LottoResult(
    val rank: LottoRank,
    val count: Int,
)
