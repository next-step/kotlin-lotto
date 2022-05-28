package camp.nextstep.lotto.raffle

import camp.nextstep.lotto.ticket.LottoTicket

object LottoResultMatcher {

    fun winningTickets(tickets: List<LottoTicket>, winnerNumbers: List<Int>): List<WinningTicket> {
        val result = mutableListOf<WinningTicket>()

        for (ticket in tickets) {
            val matchedCount = count(ticket, winnerNumbers)

            if (Winnings.isWinningCount(matchedCount)) {
                result.add(WinningTicket(Winnings.of(matchedCount), ticket))
            }
        }

        return result
    }

    fun count(ticket: LottoTicket, winnerNumbers: List<Int>): Int {
        return winnerNumbers.count { ticket.numbers.contains(it) }
    }
}
