package lotto.service

import lotto.domain.LottoRank

data class LottoResultResponse(
    val ranks: List<LottoRank>,
    var profit: Double
)
