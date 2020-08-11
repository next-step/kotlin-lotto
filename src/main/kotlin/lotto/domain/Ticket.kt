package lotto.domain

class Ticket(i1: Int, i2: Int, i3: Int, i4: Int, i5: Int, i6: Int) {
    constructor(numbers: List<Int>) : this(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5])

    val numbers = setOf(i1, i2, i3, i4, i5, i6)

    init {
        require(numbers.all { it in 1 until 45 })
        require(numbers.size == 6)
    }

    fun countMatches(ticket: Ticket): Int {
        return numbers.count { ticket.numbers.contains(it) }
    }
}
