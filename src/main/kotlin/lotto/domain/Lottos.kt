package lotto.domain

class Lottos(private val values: List<Lotto>) : List<Lotto> by values {

    fun winningStatistics(winningNumbers: WinningNumbers): Map<Rank, Int> {
        val baseRankMap = values.map(winningNumbers::matches)
            .groupingBy { it }
            .eachCount()

        return Rank.groupingByRank { baseRankMap.getOrDefault(it, 0) }
    }
}
