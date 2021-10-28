package lotto.domain

enum class Reward(
    val matchCount: Int,
    val amount: Int,
    val isMatch: (match: Int, isBonus: Boolean) -> Boolean
) {
    FIRST(6, 2_000_000_000, { match, isBonus -> 6 == match }),
    SECOND(5, 30_000_000, { match, isBonus -> 5 == match && isBonus }),
    THIRD(5, 1_500_000, { match, isBonus -> 5 == match && !isBonus }),
    FOURTH(4, 50_000, { match, isBonus -> 4 == match }),
    FIFTH(3, 5_000, { match, isBonus -> 3 == match }),
    NONE(0, 0, { match, isBonus -> false });

    fun hasNoMatch(): Boolean {
        return NONE == this
    }

    fun hasBonus(): Boolean {
        return BONUS_REWARDS.contains(this)
    }

    companion object {
        private val BONUS_REWARDS = listOf(SECOND)

        fun of(matchCount: Int, isBonus: Boolean): Reward {
            return values().find { it.isMatch(matchCount, isBonus) } ?: NONE
        }
    }
}
