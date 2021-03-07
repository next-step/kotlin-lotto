package lotto.model

import lotto.model.LottoPlace.*

class LottoChecker(private val winningNumbers: List<Int>) {
    fun check(tickets: LottoTickets, sumCostOfTickets: Money) : LottoResult {
        val winningCountMap = mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0)

        tickets.forEach { ticket ->
            val matchCount = winningNumbers.count {
                ticket.numbers.contains(it)
            }

            LottoPlace.match(matchCount)?.let {
                winningCountMap.put(it, winningCountMap.getValue(it) + 1)
            }
        }

        return LottoResult(winningCountMap, sumCostOfTickets)
    }
}
