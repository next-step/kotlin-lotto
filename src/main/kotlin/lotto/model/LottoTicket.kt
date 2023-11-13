package lotto.model

data class LottoTicket(
    val games: List<Game> = emptyList()
) {
    fun winnerAggregate(winningNumbers: WinningNumbers): LottoWinners {
        val rankAggregated: MutableMap<Rank, Int> = mutableMapOf()
        games.asSequence()
            .map { winningNumbers.toRank(it) }
            .forEach { rankAggregated[it] = rankAggregated.getOrDefault(it, 0) + 1 }
        return LottoWinners(
            totalGameCount = this.games.size,
            rankAggregated
        )
    }
}
