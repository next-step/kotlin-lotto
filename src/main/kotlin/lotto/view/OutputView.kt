package lotto.view

import lotto.GameResult
import lotto.Lottos

interface OutputView {
    fun showPurchased(lottos: Lottos)

    fun show(result: GameResult)
}
