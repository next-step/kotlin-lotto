package domain.lotto.domain

import domain.lotto.error.InvalidNumberOfMatchException

class Rank(private val numberOfMatch: Int, private val needBonusBall: Boolean) {
    init {
        if (!(Lotto.MINIMUM_SIZE..Lotto.MAXIMUM_SIZE).contains(numberOfMatch)) {
            throw InvalidNumberOfMatchException(numberOfMatch)
        }
    }

    fun isUseBonusBall(isMatchBonus: Boolean): Boolean {
        if (needBonusBall) {
            return isMatchBonus
        }
        return false
    }
}
