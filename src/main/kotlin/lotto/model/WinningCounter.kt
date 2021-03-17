package lotto.model

import lotto.model.WinningPlace.FIRST
import lotto.model.WinningPlace.SECOND
import lotto.model.WinningPlace.THIRD
import lotto.model.WinningPlace.FOURTH
import lotto.model.WinningPlace.FIFTH
import lotto.model.WinningPlace.MISS

data class WinningCounter constructor(
    val counter: MutableMap<WinningPlace, Int> = mutableMapOf(
        FIRST to 0,
        SECOND to 0,
        THIRD to 0,
        FOURTH to 0,
        FIFTH to 0
    )
) : Map<WinningPlace, Int> by counter {
    val priceSum: Money
        get() {
            return counter.entries.fold(Money.ZERO, sumWinningsTimesCount())
        }

    constructor(tickets: LottoTickets, winningCondition: WinningCondition) : this() {
        tickets.forEach {
            val winningCount = it.countMatch(winningCondition.winningNumbers)
            val bonusCount = it.countMatch(winningCondition.bonusNumber)

            record(winningCount, bonusCount)
        }
    }

    private fun sumWinningsTimesCount() =
        { accu: Money, (winningPlace: WinningPlace, winningCount: Int): MutableMap.MutableEntry<WinningPlace, Int> ->
            accu + winningPlace.price * winningCount
        }

    private fun record(matchCount: Int, bonusCount: Int) {
        val place = WinningPlace.match(matchCount, bonusCount > 0)

        increment(place)
    }

    private fun increment(place: WinningPlace) {
        if (place == MISS) {
            return
        }

        counter[place] = counter.getValue(place) + 1
    }
}
