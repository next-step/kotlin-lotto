package lotto.domain

import lotto.model.Lotto
import lotto.model.LottoNumbers
import lotto.model.LottoPrize
import lotto.model.WinningLotto

class LottoMatcher {

    fun match(winningLotto: WinningLotto, userLotto: Lotto): LottoPrizeResults =
        userLotto.numbers.mapNotNull { LottoPrize.of(matchCount(winningLotto, it)) }
            .let(::LottoPrizeResults)

    private fun matchCount(winningLotto: WinningLotto, userLottoNumbers: LottoNumbers): Int {
        return winningLotto.numbers.filter { userLottoNumbers.value.contains(it) }.size
    }
}
