package lotto.domain.analysis

import math.PositiveNumber

data class LottoAnalysisResult(
    val lottoWinRankAnalysisResults: List<LottoWinRankAnalysisResult>,
    val revenue: Revenue,
) {

    fun rankCounts(rank: LottoWinRank): PositiveNumber {
        return PositiveNumber(
            lottoWinRankAnalysisResults
                .filter { it.lottoWinRank == rank }
                .sumOf { it.ranksCount.value }
        )
    }
}
