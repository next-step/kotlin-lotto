package lotto.domain

enum class Reward(
    val matchNumber: Int,
    val reward: Int,
    val requireBonusBall: Boolean
) {
    FIRST_RANK(6, 2000000000, false),
    SECOND_RANK(5, 30000000, true),
    THIRD_RANK(5, 1500000, false),
    FOURTH_RANK(4, 50000, false),
    FIFTH_RANK(3, 5000, false),
    NO_RANK(-1, 0, false);

    companion object {
        fun getReward(matchNumber: Int, hasBonusBall: Boolean): Reward {
            return values().find { it.matchNumber == matchNumber && it.requireBonusBall == hasBonusBall } ?: NO_RANK
        }
    }
}
