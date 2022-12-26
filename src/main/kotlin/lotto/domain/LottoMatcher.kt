package lotto.domain

import lotto.model.Lotto
import lotto.model.LottoPrize
import lotto.model.WinningLotto

class LottoMatcher {

    fun match(winningLotto: WinningLotto, userLotto: List<Lotto>): LottoPrizeResults =
        userLotto.mapNotNull { LottoPrize.of(matchCount(winningLotto, it)) }
            .let(::LottoPrizeResults)

    private fun matchCount(winningLotto: WinningLotto, userLotto: Lotto): Int {
        return winningLotto.numbers.filter { userLotto.numbers.contains(it) }.size
    }
}
