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
        val sameNumber = numbers.filter { winningNumber.contains(it) }
        return when (sameNumber.size) {
            5 -> getRankWithBonus(numbers.contains(bonusNumber))
            else -> Rank.values().firstOrNull { it.sameCount == sameNumber.size }
        }
    }

    private fun getRankWithBonus(isBonusWin: Boolean): Rank {
        if (isBonusWin) {
            return Rank.SECOND
        }

        return Rank.THIRD
    }

    companion object {
        const val MAX_NUMBER = 45
        const val NUMBER_COUNT = 6
    }

}
