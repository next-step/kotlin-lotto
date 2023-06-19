package lotto.domain.analysis

data class LottoAnalysisResult(
    val lottoWinRankAnalysisResults: List<LottoWinRankAnalysisResult>,
    val revenue: Revenue,
)
