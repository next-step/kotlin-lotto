package lotto.domain

import lotto.model.Lotto
import lotto.model.WinningLotto

class LottoMatcher {

    fun match(winningLotto: WinningLotto, userLotto: List<Lotto>): LottoPrizeResults {
        return LottoPrizeResults(listOf())
    }
}
