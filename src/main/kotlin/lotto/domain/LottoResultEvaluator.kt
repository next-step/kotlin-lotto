package lotto.domain

import lotto.dto.LottoMatchResult

class LottoResultEvaluator(private val winningTicket: LottoTicket, private val bonusBall: Int) {

    fun evaluate(tickets: List<LottoTicket>): LottoMatchResult {
        val matchCounts = mutableMapOf<Int, Int>()
        var bonusMatchCount = 0

        tickets.forEach { ticket ->
            val matchCount = getMatchingNumbersCount(ticket, winningTicket)
            incrementMatchCount(matchCounts, matchCount)

            if (matchCount == 5 && ticket.readOnlyNumbers.contains(bonusBall)) {
                bonusMatchCount++
            }
        }

        return LottoMatchResult(matchCounts, bonusMatchCount)
    }

    private fun getMatchingNumbersCount(ticket: LottoTicket, winningTicket: LottoTicket): Int {
        return ticket.readOnlyNumbers.intersect(winningTicket.readOnlyNumbers).size
    }

    private fun incrementMatchCount(matchCounts: MutableMap<Int, Int>, matchCount: Int) {
        matchCounts[matchCount] = matchCounts.getOrDefault(matchCount, 0) + 1
    }
}
