package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Winning
import lotto.model.data.Winning.*

object LottoEvaluator {

    private val winningSet = setOf(LOST_GAME, FIFTH, FOURTH, THIRD, FIRST)

    fun evaluate(winningLotto: Lotto, lotto: Lotto): Winning {
        return winningSet.find { it.isWin(winningLotto, lotto) } ?: LOST_GAME
    }
}
