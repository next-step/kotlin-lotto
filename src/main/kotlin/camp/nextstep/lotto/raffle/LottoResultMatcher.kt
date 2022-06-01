package camp.nextstep.lotto.raffle

import camp.nextstep.lotto.number.LottoNumber
import camp.nextstep.lotto.ticket.LottoTicket

object LottoResultMatcher {

    fun winningTickets(tickets: List<LottoTicket>, winnerNumbers: List<LottoNumber>, bonusNumber: LottoNumber): List<WinningTicket> {
        val result = mutableListOf<WinningTicket>()

        for (ticket in tickets) {
            val matchResult = count(ticket, winnerNumbers, bonusNumber)

            if (Winnings.isWinningCount(matchResult.matchedCount)) {
                result.add(WinningTicket(Winnings.of(matchResult.matchedCount, matchResult.matchedBonus), ticket))
            }
        }

        return result
    }

    fun count(ticket: LottoTicket, winnerNumbers: List<LottoNumber>, bonusNumber: LottoNumber): LottoMatchResult {
        return LottoMatchResult(ticket.numbers.count { winnerNumbers.contains(it) }, ticket.numbers.contains(bonusNumber))
    }
}
