package camp.nextstep.lotto

object LottoResultCalculator {

    fun calculate(tickets: List<LottoTicket>, winnerNumbers: List<Int>): Map<Int, List<LottoTicket>> {
        val result = mutableMapOf<Int, MutableList<LottoTicket>>()

        for (matchCount in 0..LottoTicket.LOTTO_NUMBERS) {
            result[matchCount] = mutableListOf()
        }

        for (ticket in tickets) {
            val matchedCount = matchCount(ticket, winnerNumbers)
            requireNotNull(result[matchedCount]).add(ticket)
        }

        return result
    }

    fun matchCount(ticket: LottoTicket, winnerNumbers: List<Int>): Int {
        return winnerNumbers.count { ticket.numbers.contains(it) }
    }
}
