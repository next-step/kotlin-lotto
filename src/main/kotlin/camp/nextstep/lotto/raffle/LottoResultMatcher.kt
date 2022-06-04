package camp.nextstep.lotto.raffle

import camp.nextstep.lotto.number.WinnerNumbers
import camp.nextstep.lotto.ticket.LottoTicket

object LottoResultMatcher {

    fun winningTickets(tickets: List<LottoTicket>, winnerNumbers: WinnerNumbers): List<WinningTicket> {
        val result = mutableListOf<WinningTicket>()

        for (ticket in tickets) {
            val matchResult = count(ticket, winnerNumbers)

            if (Winnings.isWinningCount(matchResult.matchedCount)) {
                result.add(WinningTicket(Winnings.of(matchResult.matchedCount, matchResult.matchedBonus), ticket))
            }
        }

        return result
    }

    fun count(ticket: LottoTicket, winnerNumbers: WinnerNumbers): LottoMatchResult {
        return LottoMatchResult(winnerNumbers.count(ticket.numbers), ticket.numbers.numbers.contains(winnerNumbers.bonusNumber))
    }
}
