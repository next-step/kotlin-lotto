package lotto.model

data class Round(
    val games: List<Game> = emptyList(),
) {
    fun winnerAggregate(winningNumbers: WinningNumbers): LottoWinners {
        val rankAggregated: MutableMap<Rank, Int> = mutableMapOf()
        games.map { winningNumbers.countOfMatch(it) }
            .asSequence()
            .map { Rank.matchCountToRank(it) }
            .forEach { rankAggregated[it] = rankAggregated.getOrDefault(it, 0) + 1 }
        return LottoWinners(
            totalGameCount = this.games.size,
            rankAggregated
        )
    }
}
