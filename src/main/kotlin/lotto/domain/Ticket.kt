package lotto.domain

data class Ticket(val numbers: Set<Int>) {
    init {
        require(isNumberInRange(TICKET_NUMBER_MIN, TICKET_NUMBER_MAX))
        require(numbers.size == TICKET_NUMBER_SIZE) { "로또의 개수는 6개 입니다." }
    }

    private fun isNumberInRange(min: Int, max: Int): Boolean {
        return numbers.all { it in min..max }
    }

    fun countMatches(ticket: Ticket): Int {
        return numbers.count { ticket.numbers.contains(it) }
    }

    fun toRank(winningTicket: WinningTicket): Rank {
        return Rank.of(
            winningTicket.ticket.countMatches(this),
            winningTicket.bonusNumber.match(this)
        )
    }

    companion object {
        const val TICKET_NUMBER_SIZE = 6
        const val TICKET_NUMBER_MIN = 1
        const val TICKET_NUMBER_MAX = 45
    }
}
