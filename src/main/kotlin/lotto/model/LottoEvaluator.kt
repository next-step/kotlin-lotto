package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Lottos
import lotto.model.data.Result
import lotto.model.data.Results
import lotto.model.data.Winning.FIFTH
import lotto.model.data.Winning.FIRST
import lotto.model.data.Winning.FOURTH
import lotto.model.data.Winning.LOST_GAME
import lotto.model.data.Winning.THIRD

object LottoEvaluator {

    private val winningSet = setOf(LOST_GAME, FIFTH, FOURTH, THIRD, FIRST)

    fun evaluate(winningLotto: Lotto, lotto: Lotto) = Result(
        lotto,
        winningSet.find { it.isWin(winningLotto, lotto) } ?: LOST_GAME
    )

    fun evaluate(winningLotto: Lotto, lottos: Lottos) = Results(
        lottos.lottoList.map { lotto -> evaluate(winningLotto, lotto) }
    )
}
