package lotto.entity

class MatcherImpl(private val lottoNumber: LottoNumber) : Matcher {
    override fun matchOneTicket(ticket: LottoTicket): Rank {
        val matches = ticket.getWinningNumbersMatch(lottoNumber)
        if (matches == CHECK_BONUS_NUMBER) {
            if (ticket.numbers.contains(lottoNumber.bonusNumber)) return Rank.SECOND
            return Rank.THIRD
        }
        return Rank.find(matches)
    }

    override fun matchAllTickets(tickets: List<LottoTicket>): List<Rank> {
        return tickets.map { ticket -> matchOneTicket(ticket) }
    }

    override fun countTicketRanks(wallet: Wallet): WinningInfo {
        val tickets = wallet.tickets
        val ranks = matchAllTickets(tickets)
        val countOfRanks = mutableMapOf(
            Rank.FIFTH to 0,
            Rank.FOURTH to 0,
            Rank.THIRD to 0,
            Rank.SECOND to 0,
            Rank.FIRST to 0
        )
        ranks
            .groupingBy { it }
            .eachCount()
            .filter { it.key != Rank.MISS }
            .forEach { countOfRanks[it.key] = it.value }
        return WinningInfo(countOfRanks)
    }

    companion object {
        const val CHECK_BONUS_NUMBER = 5
    }
}
