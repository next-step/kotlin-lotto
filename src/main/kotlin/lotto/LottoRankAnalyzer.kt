package lotto

import lotto.domain.LottoStatistics
import lotto.domain.Rank

object LottoRankAnalyzer {
    fun analyze(matchResult: List<Rank>): List<LottoStatistics> {
        val rankMap = matchResult.groupingBy { it }.eachCount()
        return Rank.entries
            .filter { it !== Rank.MISS }
            .map { LottoStatistics(rankMap[it] ?: 0, it) }
            .sortedBy { it.rank.prizeAmount }
    }
}
