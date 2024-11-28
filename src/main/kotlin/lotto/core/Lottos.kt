package lotto.core

class Lottos(private val lottos: List<Lotto>) : List<Lotto> by lottos {
    fun countWinningRanks(winningNumbers: WinningNumbers): LottoResult {
        val results = this.map { winningNumbers.checkWinningState(it) }
        return LottoResult(results.groupingBy { it }.eachCount())
    }
}
