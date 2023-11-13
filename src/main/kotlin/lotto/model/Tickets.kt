package lotto.model

data class Tickets(
    val games: List<Game> = emptyList()
) {
    fun winnerAggregate(winningNumbers: WinningNumbers): LottoWinners {
        val rankAggregated: MutableMap<Rank, Int> = mutableMapOf()
        games.map { winningNumbers.countOfMatchAndHasBonus(it) }
            .asSequence()
            .map { Rank.of(it.first, it.second) }
            .forEach { rankAggregated[it] = rankAggregated.getOrDefault(it, 0) + 1 }
        return LottoWinners(
            totalGameCount = this.games.size,
            rankAggregated
        )
    }
}
