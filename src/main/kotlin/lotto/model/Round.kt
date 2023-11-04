package lotto.model

data class Round(
    val games: ArrayDeque<Game>,
) {
    fun winnerAggregate(winningNumbers: WinningNumbers): LottoStatistics {
        TODO("Not yet implemented")
    }
}
