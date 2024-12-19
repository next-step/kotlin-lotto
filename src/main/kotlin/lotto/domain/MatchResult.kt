package lotto.domain

class MatchResult(private val result: List<Rank>) {
    fun analyze(): List<LottoStatistics> {
        val rankMap = result.groupingBy { it }.eachCount()
        return Rank.entries
            .filter { it !== Rank.MISS }
            .map { LottoStatistics(rankMap[it] ?: 0, it) }
            .sortedBy { it.rank.prizeAmount }
    }
}
