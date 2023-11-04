package lotto.model

data class Round (
    val games: ArrayDeque<Game>,
){
    fun winnerStatistics(winningNumbers: WinningNumbers): LottoStatistics {
        TODO("Not yet implemented")
    }
}
