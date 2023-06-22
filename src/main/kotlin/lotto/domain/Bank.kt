package lotto.domain

object Bank {
    fun score(tickets: Tickets, winningTicket: WinningTicket): Map<Rank, Int> {
        val scores = tickets.tickets.map { Rank.getValue(winningTicket.score(it), winningTicket.hasBonus(it)) }
        return Rank.values().associateWith { rank -> scores.count { it == rank } }
    }

    fun calculateRateOfReturn(money: Int, score: Map<Rank, Int>): Float {
        val winningScore = score.filterKeys { score.getOrElse(it) { 0 } > 0 }
        val revenue = winningScore.keys.sumOf { winningScore.getOrElse(it) { 0 } * it.reward }
        return revenue.toFloat() / money
    }
}
