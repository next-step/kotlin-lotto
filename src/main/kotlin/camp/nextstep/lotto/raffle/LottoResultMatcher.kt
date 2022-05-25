package camp.nextstep.lotto.raffle

import camp.nextstep.lotto.number.LottoNumbers
import camp.nextstep.lotto.ticket.LottoTicket

object LottoResultMatcher {

    fun ticketsByMatchedCount(tickets: List<LottoTicket>, winnerNumbers: List<Int>): TicketsByMatchCount {
        val result = mutableMapOf<Int, MutableList<LottoTicket>>()

        for (matchCount in 0..LottoNumbers.LOTTO_NUMBERS) {
            result[matchCount] = mutableListOf()
        }

        for (ticket in tickets) {
            val matchedCount = count(ticket, winnerNumbers)
            requireNotNull(result[matchedCount]).add(ticket)
        }

        return TicketsByMatchCount(result)
    }

    fun count(ticket: LottoTicket, winnerNumbers: List<Int>): Int {
        return winnerNumbers.count { ticket.numbers.contains(it) }
    }
}
