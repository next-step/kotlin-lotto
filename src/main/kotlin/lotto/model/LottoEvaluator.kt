package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Lottos
import lotto.model.data.Result
import lotto.model.data.Results
import lotto.model.data.Winning
import lotto.model.data.Winning.LOST_GAME

object LottoEvaluator {

    private val winnings = Winning.values()
    fun evaluate(winningLotto: Lotto, lottos: Lottos) = Results(
        lottos.map { lotto -> evaluate(winningLotto, lotto) }
    )

    fun evaluate(winningLotto: Lotto, lotto: Lotto) = Result(
        lotto, winningLotto.getBestWinningFor(lotto)
    )

    fun Lotto.countOfMatchNumber(other: Lotto) =
        this.numbers.filter(other.numbers::contains).size

    private fun Lotto.getBestWinningFor(lotto: Lotto): Winning {
        return winnings.find { it.isWin(this, lotto) } ?: LOST_GAME
    }

    private fun Winning.isWin(winningLotto: Lotto, lotto: Lotto): Boolean {
        return if (this.matchCount == 0) false
        else return winningLotto.countOfMatchNumber(lotto) == this.matchCount
    }
}
