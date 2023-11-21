package lotto.domain

import lotto.dto.LottoMatchResult

class LottoResultEvaluator(private val winningTicket: LottoTicket, private val bonusBall: Int) {

    fun evaluate(tickets: List<LottoTicket>): LottoMatchResult {
        val matchCounts = mutableMapOf<Int, Int>()
        var bonusMatchCount = 0

        tickets.forEach { ticket ->
            incrementMatchCount(matchCounts, getMatchingNumbersCount(ticket, winningTicket))
            if (ticket.readOnlyNumbers.any { it.number == bonusBall } && getMatchingNumbersCount(ticket, winningTicket) == 5) {
                bonusMatchCount++
            }
        }

        return LottoMatchResult(matchCounts, bonusMatchCount)
    }

    private fun getMatchingNumbersCount(ticket: LottoTicket, winningTicket: LottoTicket): Int =
        ticket.readOnlyNumbers.intersect(winningTicket.readOnlyNumbers.toSet()).size

    private fun incrementMatchCount(matchCounts: MutableMap<Int, Int>, matchCount: Int) {
        matchCounts[matchCount] = matchCounts.getOrDefault(matchCount, 0) + 1
    }
}
