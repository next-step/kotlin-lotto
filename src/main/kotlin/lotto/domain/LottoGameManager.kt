package lotto.domain

class LottoGameManager {
    fun playLottoGame(
        tickets: List<Lotto>,
        lottoMatcher: LottoMatcher,
    ): WinningStatistics {
        val statistics =
            tickets.groupBy { lottoMatcher.match(it) }
                .mapValues { it.value.size }
        return WinningStatistics(statistics)
    }
}
