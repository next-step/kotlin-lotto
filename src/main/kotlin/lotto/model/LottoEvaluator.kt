package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Lottos
import lotto.model.data.Result
import lotto.model.data.Results
import lotto.model.data.Winning.LOST_GAME
import lotto.model.data.Winnings
import lotto.model.data.isWin

object LottoEvaluator {

    fun evaluate(winningLotto: Lotto, lottos: Lottos) = Results(
        lottos.map { lotto -> evaluate(winningLotto, lotto) }
    )

    fun evaluate(winningLotto: Lotto, lotto: Lotto) = Result(
        lotto, Winnings.find { it.isWin(winningLotto, lotto) } ?: LOST_GAME
    )
}
