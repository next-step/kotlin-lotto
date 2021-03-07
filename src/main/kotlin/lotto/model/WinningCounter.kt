package lotto.model

import lotto.model.LottoPlace.FIRST
import lotto.model.LottoPlace.SECOND
import lotto.model.LottoPlace.THIRD
import lotto.model.LottoPlace.FOURTH

data class WinningCounter(private val counter: MutableMap<LottoPlace, Int> = mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0)) {
    val winningsSum: Money
        get() {
            return counter.entries.fold(Money.zero(), sumWinningsTimesCount())
        }

    private fun sumWinningsTimesCount() = { accu: Money, (lottoPlace, winningCount): MutableMap.MutableEntry<LottoPlace, Int> ->
        accu.add(lottoPlace.winnings.times(winningCount))
    }

    fun record(matchCount: Int) {
        LottoPlace.match(matchCount)?.let {
            counter.put(it, counter.getValue(it) + 1)
        }
    }
}
