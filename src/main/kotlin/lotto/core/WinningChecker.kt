package lotto.core

object WinningChecker {
    fun markWinningStatus(
        lottos: Lottos,
        winningNumbers: WinningNumbers,
    ) {
        lottos.forEach {
            it.checkWinningStates(winningNumbers)
        }
    }
}
