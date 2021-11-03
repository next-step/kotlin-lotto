package domain.lotto.domain

import domain.lotto.error.InvalidNumberOfMatchException

class Rank(val numberOfMatch: Int, val necessityOfBonus: Boolean = false) {
    init {
        if (!(Lotto.MINIMUM_SIZE..Lotto.MAXIMUM_SIZE).contains(numberOfMatch)) {
            throw InvalidNumberOfMatchException(numberOfMatch)
        }
    }

    fun isEqualToNumberOfMatch(otherNumberOfMatch: Int): Boolean =
        (numberOfMatch == otherNumberOfMatch)

    fun isEqualToNecessityOfBonus(isMatchBonus: Boolean): Boolean =
        (necessityOfBonus == calculateNecessity(isMatchBonus))

    private fun calculateNecessity(isMatchBonus: Boolean): Boolean {
        if (necessityOfBonus) {
            return isMatchBonus
        }
        return false
    }
}
