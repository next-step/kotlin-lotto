package lotto.domain

/**
 *
 * @author Leo
 */
class Ticket(val numbers: List<Int>) {

    init {
        require(numbers.none { it > MAX_NUMBER })
        require(numbers.toMutableSet().size == NUMBER_COUNT)
    }

    fun getRank(winningNumber: List<Int>): Rank {
        return this.find(winningNumber) ?: Rank.NONE
    }

    fun find(winningNumber: List<Int>): Rank? {
        val sameNumber = numbers.filter { winningNumber.contains(it) }
        return Rank.values().firstOrNull { it.sameCount == sameNumber.size }
    }

    companion object {
        const val MAX_NUMBER = 45
        const val NUMBER_COUNT = 6
    }

}
