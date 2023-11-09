package lotto.model

data class Round(
    val games: List<Game> = emptyList(),
) {
    fun winnerAggregate(winningNumbers: WinningNumbers): LottoWinners {
        val map = games.map { winningNumbers.countOfMatch(it) }
        return LottoWinners(
            totalGameCount = this.games.size,
            countOf1st = map.count { it == 6 },
            countOf3rd = map.count { it == 5 },
            countOf4th = map.count { it == 4 },
            countOf5th = map.count { it == 3 },
        )
    }
}
