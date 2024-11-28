package lotto.core

class Lottos(private val lottos: List<Lotto>) : List<Lotto> by lottos {
    fun countWinningRanks(winningNumbers: WinningNumbers): Map<WinningRank, Int> {
        val results = this.map { checkWinningState(it, winningNumbers) }

        return results.groupingBy { it }.eachCount()
    }

    private fun checkWinningState(
        lotto: Lotto,
        winningNumbers: WinningNumbers,
    ): WinningRank {
        return WinningRank.getWinningAmount(winningNumbers.countCommonNumbers(lotto))
    }
}
