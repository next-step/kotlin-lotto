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

    fun getRank(winningNumber: List<Int>, bonusNumber: Int): Rank {
        return this.find(winningNumber, bonusNumber) ?: Rank.NONE
    }

    private fun find(winningNumber: List<Int>, bonusNumber: Int): Rank? {
        val sameNumbers = numbers.filter { winningNumber.contains(it) }
        val isBonusWin = numbers.contains(bonusNumber)
        return Rank.rank(sameNumbers, isBonusWin)
    }

    companion object {
        const val MAX_NUMBER = 45
        const val NUMBER_COUNT = 6
    }

}
