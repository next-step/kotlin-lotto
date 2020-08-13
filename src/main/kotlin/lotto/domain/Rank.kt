package lotto.domain

private const val FIRST_REWARD = 2000000000
private const val SECOND_REWARD = 30000000
private const val THIRD_REWARD = 1500000
private const val FOURTH_REWARD = 50000
private const val FIFTH_REWARD = 5000
private const val NONE_REWARD = 0

enum class Rank(val matches: Int, private val requireBonus: Boolean, val prize: Int) {
    FIRST_PRIZE(6, false, FIRST_REWARD),
    SECOND_PRIZE(5, true, SECOND_REWARD),
    THIRD_PRIZE(5, false, THIRD_REWARD),
    FOURTH_PRIZE(4, false, FOURTH_REWARD),
    FIFTH_PRIZE(3, false, FIFTH_REWARD),
    NONE(0, false, NONE_REWARD);

    fun sumPrize(count: Int): Int {
        return prize * count
    }

    private fun matchCount(count: Int): Boolean {
        return matches == count
    }

    private fun isBonusRequiredAndMatch(isBonusMatch: Boolean): Boolean {
        return requireBonus == requireBonus and isBonusMatch
    }

    companion object {
        fun of(count: Int, isBonusMatch: Boolean): Rank {
            return values().find {
                it.matchCount(count) && it.isBonusRequiredAndMatch(isBonusMatch)
            } ?: NONE
        }
    }
}
