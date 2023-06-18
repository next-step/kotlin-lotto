package lotto.domain

class Bank {
    fun score(tickets: List<Lotto>, winningTicket: WinningTicket): Map<Rank, Int> {
        val scores = tickets.mapNotNull { Rank.getValue(winningTicket.score(it)) }
        return Rank.values().associateWith { rank -> scores.count { it == rank } }
    }
}
