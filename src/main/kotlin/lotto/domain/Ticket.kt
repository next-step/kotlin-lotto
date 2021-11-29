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
        return Rank.find(winningNumber, this) ?: Rank.NONE
    }

    companion object {
        const val MAX_NUMBER = 45
        const val NUMBER_COUNT = 6
    }

}
