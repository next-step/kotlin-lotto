package lotto.model.winning

import lotto.model.LottoTickets
import lotto.model.Money
import lotto.model.winning.WinningPlace.FIRST
import lotto.model.winning.WinningPlace.SECOND
import lotto.model.winning.WinningPlace.THIRD
import lotto.model.winning.WinningPlace.FOURTH
import lotto.model.winning.WinningPlace.FIFTH
import lotto.model.winning.WinningPlace.MISS

data class WinningCounter private constructor(
    private val counter: Map<WinningPlace, Int>
) : Map<WinningPlace, Int> by counter {
    val priceSum: Money
        get() {
            return counter.toMutableMap().entries.fold(Money.ZERO, sumWinningsTimesCount())
        }

    constructor(lottoTickets: LottoTickets, winningCondition: WinningCondition) : this(buildCounter(lottoTickets, winningCondition))

    constructor(vararg counters: Pair<WinningPlace, Int>) : this(counters.associate { it })

    private fun sumWinningsTimesCount() =
        { accu: Money, (winningPlace: WinningPlace, winningCount: Int): MutableMap.MutableEntry<WinningPlace, Int> ->
            accu + winningPlace.price * winningCount
        }

    companion object {
        private fun buildCounter(lottoTickets: LottoTickets, winningCondition: WinningCondition): Map<WinningPlace, Int> {
            val counter = mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0, FIFTH to 0, MISS to 0)

            lottoTickets.forEach {
                val (winningCount, bonusExist) = winningCondition.check(it)

                val place = WinningPlace.match(winningCount, bonusExist)

                counter[place] = counter.getValue(place) + 1
            }

            return counter.toMap()
        }
    }
}
