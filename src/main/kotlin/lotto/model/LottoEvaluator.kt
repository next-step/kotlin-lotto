package lotto.model

import lotto.model.data.*
import lotto.model.data.Winning.LOST_GAME

object LottoEvaluator {

    private val winnings = Winning.values()

    fun evaluate(winningLotto: WinningLotto, lottos: Lottos) = Results(
        lottos.map { lotto -> evaluate(winningLotto, lotto) }
    )

    fun evaluate(winningLotto: WinningLotto, lotto: Lotto) = Result(
        lotto, winningLotto.getBestWinningFor(lotto)
    )

    fun WinningLotto.countOfMatchNumber(other: Lotto) =
        this.numbers.filter(other.numbers::contains).size

    private fun WinningLotto.getBestWinningFor(lotto: Lotto): Winning {
        return winnings.find { it.isWin(this, lotto) } ?: LOST_GAME
    }

    private fun Winning.isWin(winningLotto: WinningLotto, lotto: Lotto): Boolean {
        return if (this.matchCount == 0) false
        else return winningLotto.countOfMatchNumber(lotto) == this.matchCount
    }
}
