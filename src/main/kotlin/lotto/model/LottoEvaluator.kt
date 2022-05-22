package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Lottos
import lotto.model.data.Result
import lotto.model.data.Results
import lotto.model.data.Winning
import lotto.model.data.Winning.LOST_GAME
import lotto.model.data.WinningLotto

object LottoEvaluator {

    fun evaluate(winningLotto: WinningLotto, lottos: Lottos) = Results(
        lottos.map { lotto -> evaluate(winningLotto, lotto) }
    )

    fun evaluate(winningLotto: WinningLotto, lotto: Lotto) = Result(
        lotto, winningLotto.getBestWinningFor(lotto)
    )

    fun WinningLotto.countOfMatchNumber(other: Lotto) =
        this.numbers.filter(other.numbers::contains).size

    private fun WinningLotto.getBestWinningFor(lotto: Lotto) = Winning.values()
        .filter { it.isWin(this, lotto) }
        .maxByOrNull { it.winMoney } ?: LOST_GAME

    private fun Winning.isWin(winningLotto: WinningLotto, lotto: Lotto): Boolean {
        return when {
            this.matchCount == 0 -> false
            winningLotto.countOfMatchNumber(lotto) != this.matchCount -> false
            this.isMustBonusNumberMatch -> winningLotto.bonusNumber in lotto.numbers
            else -> true
        }
    }
}
