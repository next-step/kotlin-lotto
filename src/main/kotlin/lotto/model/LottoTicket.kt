package lotto.model

data class LottoTicket(
    val lottoGames: List<LottoGame> = emptyList()
) {
    fun winnerAggregate(winningNumbers: WinningNumbers): LottoWinners {
        val rankAggregated: MutableMap<Rank, Int> = mutableMapOf()
        lottoGames.asSequence()
            .map { winningNumbers.toRank(it) }
            .forEach { rankAggregated[it] = rankAggregated.getOrDefault(it, 0) + 1 }
        return LottoWinners(
            totalGameCount = this.lottoGames.size,
            rankAggregated
        )
    }

    operator fun plus(other: LottoTicket): LottoTicket {
        return LottoTicket(this.lottoGames + other.lottoGames)
    }
}
