package lotto.model

data class Round(
    val games: ArrayDeque<Game>,
) {
    fun winnerAggregate(winningNumbers: WinningNumbers): LottoWinners {
        TODO("Not yet implemented")
    }
}
