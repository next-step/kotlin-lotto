package lotto.domain

object Bank {
    fun score(tickets: Tickets, winningTicket: WinningTicket): List<Rank> {
        return tickets.tickets.map { Rank.getValue(winningTicket.score(it), winningTicket.hasBonus(it)) }
    }

    fun calculateRateOfReturn(money: Int, score: List<Rank>): Float {
        val revenue = score.sumOf { it.reward }
        return revenue.toFloat() / money
    }
}
