package lotto.core

class Lottos(private val lottos: List<Lotto>) : List<Lotto> by lottos {
    fun countWinningRanks(winningLotto: WinningLotto): LottoResult {
        val results = this.map { winningLotto.checkWinningState(it) }
        return LottoResult(results.groupingBy { it }.eachCount())
    }
}
