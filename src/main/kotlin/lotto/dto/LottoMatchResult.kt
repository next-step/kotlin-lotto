package lotto.dto

import lotto.domain.LottoTicket
import lotto.enum.Rank

class LottoMatchResult(private val tickets: List<LottoTicket>, private val winningTicket: LottoTicket, private val bonusBall: Int) {
    private val matchCount = mutableMapOf<Int, Int>()
    var bonusMatchCount = 0
        private set

    init {
        calculateMatchCount()
    }

    fun determineRank(ticket: LottoTicket): Rank {
        val matchCount = ticket.getMatchingNumbersCount(winningTicket.getNumbers().toSet())
        val matchBonus = ticket.containsBonusBall(bonusBall)
        return Rank.valueOf(matchCount, matchBonus)
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
        val count = ticket.getMatchingNumbersCount(winningTicket.getNumbers().toSet())
        when {
            count == 5 && ticket.containsBonusBall(bonusBall) -> bonusMatchCount++
            else -> matchCount[count] = matchCount.getOrDefault(count, 0) + 1
        }
    }
}
