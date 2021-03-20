package lotto.model

import lotto.model.WinningPlace.FIRST
import lotto.model.WinningPlace.SECOND
import lotto.model.WinningPlace.THIRD
import lotto.model.WinningPlace.FOURTH
import lotto.model.WinningPlace.FIFTH
import lotto.model.WinningPlace.MISS

data class WinningCounter private constructor(
    private val counter: MutableMap<WinningPlace, Int>,
    private val winningCondition: WinningCondition
) : Map<WinningPlace, Int> by counter {
    val priceSum: Money
        get() {
            return counter.entries.fold(Money.ZERO, sumWinningsTimesCount())
        }

    private fun sumWinningsTimesCount() =
        { accu: Money, (winningPlace: WinningPlace, winningCount: Int): MutableMap.MutableEntry<WinningPlace, Int> ->
            accu + winningPlace.price * winningCount
        }

    fun record(lottoTicket: LottoTicket) {
        val (winningCount, bonusExist) = winningCondition.check(lottoTicket)

        record(winningCount, bonusExist)
    }

    private fun record(matchCount: Int, bonusExist: Boolean) {
        val place = WinningPlace.match(matchCount, bonusExist)

        increment(place)
    }

    private fun increment(place: WinningPlace) {
        if (place == MISS) {
            return
        }

        counter[place] = counter.getValue(place) + 1
    }

    class Builder(
        private var winningCondition: WinningCondition
    ) {
        private var counter: MutableMap<WinningPlace, Int> = mutableMapOf(
            FIRST to 0,
            SECOND to 0,
            THIRD to 0,
            FOURTH to 0,
            FIFTH to 0
        )

        fun counter(counter: MutableMap<WinningPlace, Int>): Builder {
            this.counter = counter
            return this
        }

        fun winningCondition(winningCondition: WinningCondition): Builder {
            this.winningCondition = winningCondition
            return this
        }

        fun build(): WinningCounter {
            return WinningCounter(counter.toMutableMap(), winningCondition)
        }
    }
}
