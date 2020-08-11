package lotto.domain

class Ticket(_numbers: List<Int>) {
    val numbers = _numbers.toSet()

    init {
        require(numbers.all { it in 1 until 45 })
        require(numbers.size == 6)
    }

    fun countMatches(ticket: Ticket): Int {
        return numbers.count { ticket.numbers.contains(it) }
    }
}
