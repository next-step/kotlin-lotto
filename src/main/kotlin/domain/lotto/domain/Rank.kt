package domain.lotto.domain

import domain.lotto.error.InvalidNumberOfMatchException

class Rank(val numberOfMatch: Int, private val needBonusBall: Boolean = false) {
    init {
        if (!(Lotto.MINIMUM_SIZE..Lotto.MAXIMUM_SIZE).contains(numberOfMatch)) {
            throw InvalidNumberOfMatchException(numberOfMatch)
        }
    }

    fun sameAsNumberOfMatch(otherNumberOfMatch: Int) = numberOfMatch == otherNumberOfMatch

    fun sameAsNeedBonusBall(isMatchBonus: Boolean): Boolean {
        return needBonusBall == isUseBonusBall(isMatchBonus)
    }

    private fun isUseBonusBall(isMatchBonus: Boolean): Boolean {
        if (needBonusBall) {
            return isMatchBonus
        }
        return false
    }
}
