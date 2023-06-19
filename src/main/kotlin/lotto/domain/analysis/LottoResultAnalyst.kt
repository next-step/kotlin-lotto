package lotto.domain.analysis

import lotto.domain.money.sum
import lotto.domain.money.toMoney
import math.PositiveNumber
import math.orZero

class LottoResultAnalyst {

    fun analyze(request: LottoAnalysisRequest): LottoAnalysisResult {
        val winRankAnalysisResults = analyzeWinRanks(request)
        val revenue = calculateRevenue(
            lottoPurchaseAmount = request.lottoPurchaseAmount,
            winRankMatchResults = winRankAnalysisResults,
        )
        return LottoAnalysisResult(
            lottoWinRankAnalysisResults = winRankAnalysisResults,
            revenue = revenue,
        )
    }

    private fun analyzeWinRanks(
        request: LottoAnalysisRequest,
    ): List<LottoWinRankAnalysisResult> {
        return calculateWinRankCount(request)
            .map { (lottoWinRank, winCount) -> LottoWinRankAnalysisResult(lottoWinRank, winCount) }
            .sortedByDescending { analysisResult -> analysisResult.lottoWinRank }
    }

    private fun calculateWinRankCount(
        request: LottoAnalysisRequest,
    ): Map<LottoWinRank, PositiveNumber> {
        val result = LottoWinRank.values()
            .associateWith { PositiveNumber(0) }
            .toMutableMap()

        request.lottoGames
            .mapNotNull { lottoGame -> lottoGame.matchOrNull(request.lastWeekWinLottoNumbers) }
            .forEach { lottoWinRank -> result[lottoWinRank] = result[lottoWinRank].orZero().plus(1) }

        return result.toMap()
    }

    private fun calculateRevenue(
        lottoPurchaseAmount: PositiveNumber,
        winRankMatchResults: List<LottoWinRankAnalysisResult>,
    ): Revenue {
        return Revenue(
            totalCost = lottoPurchaseAmount.toMoney(),
            totalRevenue = winRankMatchResults.map { it.totalWinAmount }.sum()
        )
    }
}
