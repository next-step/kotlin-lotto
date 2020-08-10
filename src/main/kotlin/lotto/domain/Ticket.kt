package lotto.domain

class Ticket(i1: Int, i2: Int, i3: Int, i4: Int, i5: Int, i6: Int) {
    private val set = setOf(i1, i2, i3, i4, i5, i6)

    init {
        require(set.all { it in 1 until 45 })
        require(set.size == 6)
    }

    fun countMatches(ticket: Ticket): Int {
        return set.count { ticket.set.contains(it) }
    }
}
