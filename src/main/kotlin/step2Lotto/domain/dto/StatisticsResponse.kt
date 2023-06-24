package step2Lotto.domain.dto

import step2Lotto.domain.LottoRank

data class StatisticsResponse(
    val lottoStatistics: List<LottoRank>,
)
