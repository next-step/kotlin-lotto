package lotto.dto

import lotto.domain.LottoTicket
import lotto.enum.Rank

class LottoMatchResult(private val tickets: List<LottoTicket>, winningTicket: LottoTicket, private val bonusBall: Int) {
    private val winningNumbers = winningTicket.readOnlyNumbers.toSet()
    private val matchCount = mutableMapOf<Int, Int>()
    var bonusMatchCount = 0
        private set

    init {
        calculateMatchCount()
    }

    fun determineRank(ticket: LottoTicket): Rank {
        val matchCount = getMatchingNumbersCount(ticket)
        val matchBonus = containsBonusBall(ticket)
        return Rank.valueOf(matchCount, matchBonus)
    }

    fun getMatchCount(match: Int): Int {
        return matchCount.getOrDefault(match, 0)
    }

    private fun getMatchingNumbersCount(ticket: LottoTicket): Int {
        return ticket.readOnlyNumbers.intersect(winningNumbers).size
    }

    private fun calculateMatchCount() {
        tickets.forEach { ticket ->
            incrementMatchCount(ticket)
        }
    }

    private fun containsBonusBall(ticket: LottoTicket): Boolean {
        return ticket.readOnlyNumbers.contains(bonusBall)
    }

    private fun incrementMatchCount(ticket: LottoTicket) {
        val currentMatchCount = getMatchingNumbersCount(ticket)
        matchCount[currentMatchCount] = matchCount.getOrDefault(currentMatchCount, 0) + 1
        if (currentMatchCount == 5 && containsBonusBall(ticket)) {
            bonusMatchCount++
        }
    }
}
