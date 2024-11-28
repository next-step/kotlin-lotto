package lotto.core

class Lottos(private val lottos: List<Lotto>) : List<Lotto> by lottos {
    fun countWinningRanks(winningNumbers: WinningNumbers): LottoResult {
        val results = this.map { checkWinningState(it, winningNumbers) }
        return LottoResult(results.groupingBy { it }.eachCount())
    }

    private fun checkWinningState(
        lotto: Lotto,
        winningNumbers: WinningNumbers,
    ): WinningRank {
        return WinningRank.getRank(winningNumbers.countCommonNumbers(lotto))
    }
}
