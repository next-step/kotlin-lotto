package lotto.domain

class LottoMatcher(private val winningLotto: Lotto, private val bonusNumber: LottoNumber) {
    fun match(ticket: Lotto): WinningCategory {
        val matchCount = ticket.countMatchingNumbers(winningLotto)
        val matchBonus = ticket.hasNumber(bonusNumber)
        return WinningCategory.fromMatchCount(matchCount, matchBonus)
    }

    fun evaluateTickets(tickets: LottoTickets): WinningStatistics {
        val statistics =
            tickets.getTickets()
                .groupBy { match(it) }
                .mapValues { it.value.size }
        return WinningStatistics(statistics)
    }
}
