package lotto.dto

import lotto.domain.LottoTicket

class LottoMatchResult(private val tickets: List<LottoTicket>, private val winningNumbers: Set<Int>) {
    private val matchCount = mutableMapOf<Int, Int>()

    init {
        calculateMatchCount()
    }

    fun getMatchCount(match: Int): Int {
        return matchCount.getOrDefault(match, 0)
    }

    private fun calculateMatchCount() {
        for (ticket in tickets) {
            val count = ticket.getMatchingNumbersCount(winningNumbers)
            matchCount[count] = matchCount.getOrDefault(count, 0) + 1
        }
    }
}
