package lotto.dto

import lotto.domain.LottoTicket

class LottoMatchResult(private val tickets: List<LottoTicket>, private val winningNumbers: Set<Int>, private val bonusBall: Int) {
    private val matchCount = mutableMapOf<Int, Int>()
    var bonusMatchCount = 0
        private set

    init {
        calculateMatchCount()
    }

    fun getMatchCount(match: Int): Int {
        return matchCount.getOrDefault(match, 0)
    }

    private fun calculateMatchCount() {
        tickets.forEach { ticket ->
            incrementMatchCount(ticket)
        }
    }

    private fun incrementMatchCount(ticket: LottoTicket) {
        val count = ticket.getMatchingNumbersCount(winningNumbers)
        when {
            count == 5 && ticket.containsBonusBall(bonusBall) -> bonusMatchCount++
            else -> matchCount[count] = matchCount.getOrDefault(count, 0) + 1
        }
    }
}
