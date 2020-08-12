package lotto.domain

class Ticket(val numbers: Set<Int>) {
    init {
        require(numberIsInRange(TICKET_NUMBER_MIN, TICKET_NUMBER_MAX))
        require(isSize(TICKET_NUMBER_SIZE))
    }

    private fun numberIsInRange(min: Int, max: Int): Boolean {
        return numbers.all { it in min until max }
    }

    private fun isSize(size: Int): Boolean {
        return numbers.size == size
    }

    fun countMatches(ticket: Ticket): Int {
        return numbers.count { ticket.numbers.contains(it) }
    }

    companion object {
        const val TICKET_NUMBER_SIZE = 6
        const val TICKET_NUMBER_MIN = 1
        const val TICKET_NUMBER_MAX = 45
    }
}
