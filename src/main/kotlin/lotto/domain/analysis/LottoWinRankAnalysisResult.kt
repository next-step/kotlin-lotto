package lotto.domain.analysis

import common.PositiveNumber

data class LottoWinRankAnalysisResult(
    val lottoWinRank: LottoWinRank,
    val ranksCount: PositiveNumber,
)
