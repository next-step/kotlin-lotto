package lotto.domain

/**
 *
 * @author Leo
 */
enum class Rank(val prize: Int, val sameCount: Int) {

    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3),
    NONE(0, 0);

    companion object {
        fun find(winningNumber: List<Int>, ticket: Ticket): Rank? {
            val sameNumber = ticket.numbers.filter { winningNumber.contains(it) }
            return values().firstOrNull { it.sameCount == sameNumber.size }
        }
    }

}
