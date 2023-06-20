package lotto.domain

object Bank {
    fun score(tickets: List<Lotto>, winningTicket: WinningTicket): Map<Rank, Int> {
        val scores = tickets.map { Rank.getValue(winningTicket.score(it)) }
        return Rank.values().associateWith { rank -> scores.count { it == rank } }
    }

    fun calculateRateOfReturn(money: Int, score: Map<Rank, Int>): Float {
        val winningScore = score.filterKeys { score[it]!! > 0 }
        val revenue = winningScore.keys.sumOf { winningScore[it]?.times(it.reward) ?: 0 }
        return revenue.toFloat() / money
    }
}
