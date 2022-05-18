package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Lottos
import lotto.model.data.Result
import lotto.model.data.Results
import lotto.model.data.Winning.LOST_GAME
import lotto.model.data.WinningSet

object LottoEvaluator {

    fun evaluate(winningLotto: Lotto, lotto: Lotto) = Result(
        lotto,
        WinningSet.find { it.isWin(winningLotto, lotto) } ?: LOST_GAME
    )

    fun evaluate(winningLotto: Lotto, lottos: Lottos) = Results(
        lottos.lottoList.map { lotto -> evaluate(winningLotto, lotto) }
    )
}
